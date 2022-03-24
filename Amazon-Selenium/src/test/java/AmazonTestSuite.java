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
    private AmazonProductPage amazonProductPage;
    private AmazonCartPage amazonCartPage;
    private AmazonSearchResultPage amazonSearchResultPage;
    private WebDriver driver;
    private String book = "The Cucumber Book: Behaviour-Driven Development for Testers and Developers";
    private String isbn = "978-1680502381";

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
    public void searchResults(){
        amazonSearchResultPage = new AmazonSearchResultPage(driver);
        amazonSearchResultPage.clickImage();
        Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(), book);
    }

    @Test(dependsOnMethods = "searchResults")
    public void cart() {
        amazonProductPage = new AmazonProductPage(driver);
        amazonProductPage.getAddToCartButton().click();
        Assert.assertEquals(amazonProductPage.getCartQty().getText(), "1");
        driver.findElement(By.id("nav-cart")).click();

        amazonCartPage = new AmazonCartPage(driver);
        // Assert.assertEquals(amazonCartPage.getSubtotal().getText(), "$32.62");

        amazonCartPage.getDelete().click();
        Assert.assertEquals(amazonCartPage.getEmptyCart().getText(), "Your Amazon Cart is empty.");
        
        amazonCartPage.getDeleteMessage();
        Assert.assertEquals(amazonProductPage.getISBN(), isbn);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
