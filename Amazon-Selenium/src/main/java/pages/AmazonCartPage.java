package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCartPage{
    private WebDriver driver;

    public AmazonCartPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getSubtotal(){
        return driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span"));
    }

    public WebElement getDelete(){
        return driver.findElement(By.xpath("//input[@value='Delete']"));
    }

    public WebElement getEmptyCart(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Your Amazon Cart is empty')]"));
    }

    public String getDeleteMessageURL(){
        return driver.findElement(By.xpath("//span[contains(text(), 'was removed from Shopping Cart.')]/a")).getAttribute("href");
    }
}