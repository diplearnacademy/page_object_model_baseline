package co.dlacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utilities.Strings;

import java.util.Map;

public class ProductModalPage extends  BasePage{

    By btnContinueShopping = By.xpath("//button[text()='Continue shopping']");
    By btnAddProduct = By.xpath("//button[@data-button-action='add-to-cart']");

    By modalContinueShoping = By.id("blockcart-modal");

    By selectSize = By.xpath("//select[@data-product-attribute='1']");
    By selectDimention = By.xpath("//select[@data-product-attribute='3']");
    By radioButtonWhite = By.xpath("//input[@class='input-color' and @value='8']");
    By radioButtonBlack = By.xpath("//input[@class='input-color' and @value='11']");

    By inputamount = By.id("quantity_wanted");

    public ProductModalPage(WebDriver driver) {
        super(driver);
    }

    public  void addProductCar(){
        WebElement btnEleAddProduct = driver.findElement(btnAddProduct);
        wait.until(ExpectedConditions.elementToBeClickable(btnEleAddProduct));
        driver.findElement(btnAddProduct).click();

    }

    public  void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(modalContinueShoping));
        WebElement btnElementContinueShoping = driver.findElement(btnContinueShopping);
        wait.until(ExpectedConditions.elementToBeClickable(btnElementContinueShoping));
        driver.findElement(btnContinueShopping).click();
    }

    private void selectColorProduct(String color) throws InterruptedException {
        if(color.equalsIgnoreCase("blanco")){
            driver.findElement(radioButtonWhite).click();
        } else if (color.equalsIgnoreCase("negro")) {
            driver.findElement(radioButtonBlack).click();
        }
    }

    private void selectCaracteristic(String caracteristic,String value) throws InterruptedException {
        Select select;
        WebElement elemenSelect;

        switch (caracteristic.toLowerCase()){
            case "talla":
                elemenSelect = driver.findElement(selectSize);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectSize));
                select = new Select(elemenSelect);
                select.selectByVisibleText(value);
                break;
            case "dimension":
                elemenSelect = driver.findElement(selectDimention);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectDimention));
                select = new Select(elemenSelect);
                select.selectByVisibleText(value);
                break;
            case "color":
                selectColorProduct(value);
                break;
            default:
                System.out.println("opcion no valida");
        }
    }



    public  void SelectCaracteristics(String caracteristics) throws InterruptedException {
        Map<String,String> caracteristicsMap = Strings.parseCaracteristicProducts(caracteristics);

        for (Map.Entry<String, String> entry : caracteristicsMap.entrySet()) {
            selectCaracteristic(entry.getKey(),entry.getValue());
        }
    }

    public void selectAmount(String amount) throws InterruptedException {
        driver.findElement(inputamount).clear();
        driver.findElement(inputamount).sendKeys(amount);
    }
}
