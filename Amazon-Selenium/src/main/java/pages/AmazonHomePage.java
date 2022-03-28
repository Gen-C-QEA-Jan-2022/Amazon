package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
    private final String url = "https://www.amazon.com/";
    private WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
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
