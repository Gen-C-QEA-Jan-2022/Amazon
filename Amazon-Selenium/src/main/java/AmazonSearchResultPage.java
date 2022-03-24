import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchResultPage {
    private WebDriver driver;
    private String book = "The Cucumber Book: Behaviour-Driven Development for Testers and Developers";

    public AmazonSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getImage() {
        return driver.findElement(By.cssSelector("img[alt='" + book + "']"));
    }

    public void clickImage(){
        getImage().click();
    }
}