import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonTestSuite {
    private AmazonHomePage amazonHomePage;
    private WebDriver driver;
    private String book = "The Cucumber Book: Behaviour-Driven Development for Testers and Developers";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void search() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.useSearchBox("Cucumber Testing");
        Assert.assertTrue(driver.getPageSource().contains(book));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
