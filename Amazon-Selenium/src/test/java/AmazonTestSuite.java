import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class AmazonTestSuite {
    private AmazonHomePage amazonHomePage;
    private AmazonCartPage amazonCartPage;
    private WebDriver driver;
    private String book = "The Cucumber Book: Behaviour-Driven Development for Testers and Developers";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void search() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.useSearchBox("Cucumber Testing");
        Assert.assertTrue(driver.getPageSource().contains(book));
    }

    @Test(dependsOnMethods = "search")
    public void cart() {
        // Temporary usage to get to cart window.
        driver.findElement(By.cssSelector("img[alt='" + book + "']")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("nav-cart")).click();
        
        amazonCartPage = new AmazonCartPage(driver);
        Assert.assertEquals(amazonCartPage.getSubtotal().getText(), "$32.62");

        amazonCartPage.getDelete().click();
        Assert.assertEquals(amazonCartPage.getEmptyCart().getText(), "Your Amazon Cart is empty.");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
