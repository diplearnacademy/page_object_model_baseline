package co.dlacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    By lupa = By.xpath("//a[contains(.,'sweater')]/../..//following-sibling::div//i");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickEnLupa()
    {
        driver.findElement(lupa).click();
    }
}
