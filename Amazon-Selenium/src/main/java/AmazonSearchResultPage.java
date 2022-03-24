import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
    private final String url = "https://www.amazon.com/s?k=cucumber+testing&crid=D3LLNEPVZF6H&sprefix=cucumber+testing%2Caps%2C88&ref=nb_sb_noss";
    private WebDriver driver;

    public AmazonSearchResultPage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
    }

    public WebElement getImage() {
        return driver.findElement(By.className("sg-col sg-col-4-of-12 sg-col-4-of-16 sg-col-4-of-20 s-list-col-left"));
    }

    public clickImage(){
        getImage().click();
    }

}