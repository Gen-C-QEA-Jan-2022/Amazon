package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCartPage{
    //private final String url = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
    private WebDriver driver;

    public AmazonCartPage(WebDriver driver){
        this.driver = driver;
        //driver.get(url); //Is this necessary if the page is navigated to via previous steps?
    }

    public WebElement getSubtotal(){
        return driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span"));
    }

    public WebElement getDelete(){
        return driver.findElement(By.xpath("//input[@value='Delete']"));
    }

    public WebElement getEmptyCart(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Your Amazon Cart is empty')]"));
        //Seems the header size is different depending on what the last action was? Gonna use a * to just
        //be safe.
        //return driver.findElement(By.xpath("//h2[contains(text(), 'Your Amazon Cart is empty')]")); 
    }

    public WebElement getDeleteMessage(){
        return driver.findElement(By.xpath("//span[contains(text(), 'was removed from Shopping Cart.')]/a"));
    }

    public void quit(){
        driver.quit();
    }

}