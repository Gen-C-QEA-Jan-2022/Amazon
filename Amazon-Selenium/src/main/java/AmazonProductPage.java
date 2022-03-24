import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AmazonProductPage {
    private WebDriver driver;

    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPaperBack(String url) {
        return driver.findElement(By.cssSelector("a[href*='" + url + "']"));
    }

    public WebElement getBuyNowButton () {
        return driver.findElement(By.id("buy-now-button"));
    }

    public WebElement getAddToCartButton () {
        return driver.findElement(By.id("add-to-cart-button"));
    }

    public WebElement getCartQty(){
        return driver.findElement(By.id("nav-cart-count"));
    }

    public String getISBN() {
        String isbn13 = driver.findElement(By.xpath("//*[@id='isbn_feature_div']/div/div[1]/span[2]")).getText();
        return isbn13;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}