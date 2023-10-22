package co.dlacademy.pages;

import co.dlacademy.utilities.FormatNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPayPage extends BasePage {

    By payPrice =  By.xpath("//div[@data-testid='price-item-total']");

    public ConfirmPayPage(WebDriver driver) {
        super(driver);
    }


    public double getPayPrice(){
        return FormatNumber.converStrinDouble(driver.findElement(payPrice).getText());
    }

}
