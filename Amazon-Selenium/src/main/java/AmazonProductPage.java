import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AmazonProductPage {

    private final String url = "https://www.amazon.com/Cucumber-Book-Behaviour-Driven-Development-Developers/dp/1680502387/ref=sr_1_1?crid=1YBJT2M79S2DU&keywords=cucumber+book&qid=1648064227&sprefix=cucumber+book%2Caps%2C240&sr=8-1";
    private WebDriver driver;

    public AmazonProductPage(WebDriver driver) {

        this.driver = driver;
        driver.get(url);
    }

    public WebElement getPaperBack() {

        WebElement paperBack = driver.findElement(By.xpath("//*[@id=\"mediaTab_heading_1\"]/a"));
        paperBack.click();
        return paperBack;
    }

        public WebElement getBuyNowButton () {
            WebElement buyNow = driver.findElement(By.id("buy-now-button"));
            //buyNow.click();
            return buyNow;
        }


    public WebElement getAddToCartButton () {
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        //addToCart.click();
        return addToCart;
    }

    public String getISBN() {
        String isbn13 = driver.findElement(By.id("//*[@id='isbn_feature_div']/div/div[1]/span[2]")).getText();
        return isbn13;
    }


}