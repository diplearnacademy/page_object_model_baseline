package co.dlacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage  extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    String product = "//a[contains(.,'$')]";

    public boolean productNamePresent(String procutName){
        System.out.println(driver.findElement(By.xpath(product.replace("$",procutName))).getText());
        return driver.findElement(By.xpath(product.replace("$",procutName))).isDisplayed();
    }
}
