package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AmazonConstants;

public class AmazonHomePage {
    private WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(AmazonConstants.URL);
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    public WebElement getSearchBoxButton() {
        return driver.findElement(By.id("nav-search-submit-button"));
    }

    public void useSearchBox(String item) {
        getSearchBox().sendKeys(item);
        getSearchBoxButton().click();
    }
}
