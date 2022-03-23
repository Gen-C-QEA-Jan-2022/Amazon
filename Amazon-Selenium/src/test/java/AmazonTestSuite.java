import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonTestSuite {
    private AmazonHomePage amazonHomePage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        amazonHomePage = new AmazonHomePage(new ChromeDriver());
    }

    @Test
    public void search() {
        amazonHomePage.useSearchBox("Cucumber Testing");
    }
}
