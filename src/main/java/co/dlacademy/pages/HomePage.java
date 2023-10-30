package co.dlacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{


    @FindBy(xpath= "//a[contains(.,'sweater')]/../..//following-sibling::div//i")
    WebElement linkFirstProduct;

    @FindBy(xpath = "//a[contains(.,'sweater')]")
    WebElement firstProduct;

    String product = "//a[contains(.,'$')]";

    String linkProduct = "//a[contains(.,'$')]/../..//following-sibling::div//i";

    @FindBy(xpath = "//i[text()='shopping_cart']/..")
    WebElement btnShoppingCar;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickEnLupa() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(3000);
        linkFirstProduct.click();
    }


    public void selectProduct(String productName) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(product.replace("$",productName)));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        WebElement linkElementProduct = driver.findElement(By.xpath(linkProduct.replace("$",productName)));
        wait.until(ExpectedConditions.elementToBeClickable(linkElementProduct));
        JavascriptExecutor jsExecutor  = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", linkElementProduct);
    }

    public  void openShoppingCar(){
        btnShoppingCar.click();
    }


}
