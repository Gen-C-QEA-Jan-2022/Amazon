import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

import pages.*;
import utils.AmazonConstants;

public class AmazonTestSuite {
    private AmazonHomePage amazonHomePage;
    private AmazonProductPage amazonProductPage;
    private AmazonCartPage amazonCartPage;
    private AmazonSearchResultPage amazonSearchResultPage;
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void amazon_Search_Function_Retrieves_Correct_Product() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.useSearchBox(AmazonConstants.SEARCH_ITEM);
        Assert.assertTrue(driver.getPageSource().contains(AmazonConstants.BOOK_NAME));
    }

    @Test(dependsOnMethods = "amazon_Search_Function_Retrieves_Correct_Product")
    public void amazon_Search_Results_Provide_Correct_Product_Page() {
        amazonSearchResultPage = new AmazonSearchResultPage(driver);
        amazonSearchResultPage.clickImage(AmazonConstants.BOOK_NAME);
        Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(), AmazonConstants.BOOK_NAME);
    }

    @Test(dependsOnMethods = "amazon_Search_Results_Provide_Correct_Product_Page")
    public void amazon_Product_Page_Lands_On_Paperback_Tab() {
        amazonProductPage = new AmazonProductPage(driver);
        Assert.assertEquals(amazonProductPage.checkPaperBackTab(AmazonConstants.BOOK_URL), "true");
    }

    @Test(dependsOnMethods = "amazon_Product_Page_Lands_On_Paperback_Tab")
    public void amazon_Product_Page_AddToCart_Displays_Correct_Amount() {
        amazonProductPage.getAddToCartButton().click();
        Assert.assertEquals(amazonProductPage.getCartQty().getText(), "1");
    }

    @Test(dependsOnMethods = "amazon_Product_Page_AddToCart_Displays_Correct_Amount")
    public void amazon_Cart_Page_Contains_Correct_Product_Information() {
        amazonProductPage.getCart().click();

        amazonCartPage = new AmazonCartPage(driver);
        Assert.assertEquals(amazonCartPage.getSubtotal().getText(), AmazonConstants.BOOK_PRICE);
    }

    @Test(dependsOnMethods = "amazon_Cart_Page_Contains_Correct_Product_Information")
    public void amazon_Cart_Page_Delete_Provide_Confirmation_Link() {
        amazonCartPage.getDelete().click();
        Assert.assertEquals(amazonCartPage.getEmptyCart().getText(), "Your Amazon Cart is empty.");
    }

    @Test(dependsOnMethods = "amazon_Cart_Page_Delete_Provide_Confirmation_Link")
    public void amazon_Cart_Page_Deletion_Link_Provides_Correct_Product_Page() {
        driver.get(amazonCartPage.getDeleteMessageURL());
        amazonProductPage.setDriver(driver);
        Assert.assertEquals(amazonProductPage.getISBN(), AmazonConstants.ISBN_NUM);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
