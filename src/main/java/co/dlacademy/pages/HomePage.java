package co.dlacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{

    By lupa = By.xpath("//a[contains(.,'sweater')]/../..//following-sibling::div//i");
    By producto =  By.xpath("//a[contains(.,'sweater')]");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickEnLupa() throws InterruptedException {
        WebElement elemento = driver.findElement(producto);
        Actions actions = new Actions(driver);
        actions.moveToElement(elemento).perform();
        Thread.sleep(3000);
        driver.findElement(lupa).click();
    }
}
