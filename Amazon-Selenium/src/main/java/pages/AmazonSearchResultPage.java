package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AmazonConstants;

public class AmazonSearchResultPage {
    private WebDriver driver;

    public AmazonSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getImage(String name) {
        return driver.findElement(By.cssSelector("img[alt='" + name + "']"));
    }

    public void clickImage(String name){
        getImage(name).click();
    }
}