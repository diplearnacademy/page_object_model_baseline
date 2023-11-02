package co.dlacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class
HomePage extends BasePage{

    By linkFirstProduct = By.xpath("//a[contains(.,'sweater')]/../..//following-sibling::div//i");
    By firstProduct =  By.xpath("//a[contains(.,'sweater')]");

    String product = "//a[contains(.,'$')]";

    String linkProduct = "//a[contains(.,'$')]/../..//following-sibling::div//i";

    By btnShoppingCar = By.xpath("//i[text()='shopping_cart']/..");



    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickEnLupa() throws InterruptedException {
        WebElement elemento = driver.findElement(firstProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(elemento).perform();
        WebElement firstEelement = driver.findElement(firstProduct);
        wait.until(ExpectedConditions.elementToBeClickable(firstEelement));
        firstEelement.click();
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
        driver.findElement(btnShoppingCar).click();
    }


}
