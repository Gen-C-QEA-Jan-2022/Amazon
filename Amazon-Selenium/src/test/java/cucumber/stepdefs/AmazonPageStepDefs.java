package cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.AmazonCartPage;
import pages.AmazonHomePage;
import pages.AmazonProductPage;
import pages.AmazonSearchResultPage;
import utils.AmazonConstants;

import java.time.Duration;

public class AmazonPageStepDefs {
    private AmazonHomePage amazonHomePage;
    private AmazonProductPage amazonProductPage;
    private AmazonCartPage amazonCartPage;
    private AmazonSearchResultPage amazonSearchResultPage;
    private WebDriver driver;

    // Set web driver:
    @Before
    public void start_browser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void close_browser() {
        driver.quit();
    }

    // Home Page:
    @Given("I am on the Amazon home page amazon.com")
    public void i_am_on_the_Amazon_home_page() {
        amazonHomePage = new AmazonHomePage(driver);
    }

    @When("I search for {string}")
    public void i_search_for_Cucumber_Testing(String item) {
        amazonHomePage.useSearchBox(item);
    }

    @Then("I should get a result for “The Cucumber Book: Behaviour-Driven Development for Testers and Developers”")
    public void i_should_get_a_result_for_The_Cucumber_Book() {
        Assert.assertTrue(driver.getPageSource().contains(AmazonConstants.BOOK_NAME));
    }

    // Verify Search Result/Product Page produces correct information:
    @Given("I performed the above search")
    public void i_performed_the_above_search() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.useSearchBox(AmazonConstants.SEARCH_ITEM);
        amazonSearchResultPage = new AmazonSearchResultPage(driver);
    }

    @When("I click on the image of the book")
    public void i_click_on_the_image_of_the_book() {
        amazonSearchResultPage.clickImage(AmazonConstants.BOOK_NAME);
    }

    @Then("I should be on a Paperback tab with an “Add to Cart” button")
    public void i_should_be_on_a_Paperback_tab_with_an_Add_to_Cart_button() {
        amazonProductPage = new AmazonProductPage(driver);
        Assert.assertEquals(amazonProductPage.checkPaperBackTab(AmazonConstants.BOOK_URL), "true");
    }

    // Verify Product Page Add-to-Cart functionality:
    @Given("I am on the page above")
    public void i_am_on_the_page_above() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.useSearchBox(AmazonConstants.SEARCH_ITEM);
        amazonSearchResultPage = new AmazonSearchResultPage(driver);
        amazonSearchResultPage.clickImage(AmazonConstants.BOOK_NAME);
        amazonProductPage = new AmazonProductPage(driver);
    }

    @When("I click “Add to Cart”")
    public void i_click_Add_to_Cart() {
        amazonProductPage.getAddToCartButton().click();
    }

    @Then("the anonymous shopping cart should have {int} item in it.")
    public void the_anonymous_shopping_cart_should_have_item(Integer quantity) {
        Assert.assertEquals(amazonProductPage.getCartQty().getText(), String.valueOf(quantity));
    }

    // Verify Cart Page contains correct information:
    @Given("I have performed the above actions")
    public void i_have_performed_the_above_actions() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.useSearchBox(AmazonConstants.SEARCH_ITEM);
        amazonSearchResultPage = new AmazonSearchResultPage(driver);
        amazonSearchResultPage.clickImage(AmazonConstants.BOOK_NAME);
        amazonProductPage = new AmazonProductPage(driver);
        amazonProductPage.getAddToCartButton().click();
    }

    @When("I click on the anonymous shopping cart,")
    public void i_click_on_the_anonymous_shopping_cart() {
        amazonProductPage.getCart().click();
    }

    @Then("I should see the book listed with a subtotal of ${double}")
    public void i_should_see_the_book_listed_with_a_subtotal_of_$(Double amount) {
        amazonCartPage = new AmazonCartPage(driver);
        Assert.assertEquals(amazonCartPage.getSubtotal().getText(), "$" + amount);
    }

    // Verify Cart Page Delete functionality:
    @Given("I am on the above page")
    public void i_am_on_the_above_page() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.useSearchBox(AmazonConstants.SEARCH_ITEM);
        amazonSearchResultPage = new AmazonSearchResultPage(driver);
        amazonSearchResultPage.clickImage(AmazonConstants.BOOK_NAME);
        amazonProductPage = new AmazonProductPage(driver);
        amazonProductPage.getAddToCartButton().click();
        amazonProductPage.getCart().click();
        amazonCartPage = new AmazonCartPage(driver);
    }

    @When("I click on “Delete”")
    public void i_click_on_Delete() {
        amazonCartPage.getDelete().click();
    }

    @Then("the page should tell me that my Amazon Cart is empty")
    public void the_page_should_tell_me_that_my_Amazon_Cart_is_empty() {
        Assert.assertEquals(amazonCartPage.getEmptyCart().getText(), "Your Amazon Cart is empty.");
    }

    // Verify correct Product Page:
    @When("I click the link for the removed book")
    public void i_click_the_link_for_the_removed_book() {
        amazonCartPage.getDelete().click();
        driver.get(amazonCartPage.getDeleteMessageURL());
    }

    @Then("I should see an ISBN-13 number of {int}-{int}")
    public void i_should_see_an_ISBN_number(Integer int1, Integer int2) {
        amazonProductPage.setDriver(driver);
        Assert.assertEquals(amazonProductPage.getISBN(), int1 + "-" + int2);
    }
}
