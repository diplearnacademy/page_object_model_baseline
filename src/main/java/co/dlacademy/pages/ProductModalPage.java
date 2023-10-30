package co.dlacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utilities.Strings;

import javax.xml.xpath.XPath;
import java.util.Map;

public class ProductModalPage extends  BasePage{

    @FindBy(xpath = "//button[text()='Continue shopping']")
    WebElement btnContinueShopping;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    WebElement btnAddProduct;

    @FindBy(id = "blockcart-modal")
       WebElement modalContinueShoping;

    @FindBy(xpath = "//select[@data-product-attribute='1']")
            WebElement selectSize;

    @FindBy(xpath = "//select[@data-product-attribute='3']")
            WebElement selectDimention;

    @FindBy(xpath = "//input[@class='input-color' and @value='8']")
            WebElement radioButtonWhite;

    @FindBy(xpath = "//input[@class='input-color' and @value='11']")
            WebElement radioButtonBlack;

    @FindBy(id = "quantity_wanted")
    WebElement inputamount;

    public ProductModalPage(WebDriver driver) {
        super(driver);
    }

    public  void addProductCar(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAddProduct));
        btnAddProduct.click();

    }

    public  void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfAllElements(modalContinueShoping));
        wait.until(ExpectedConditions.elementToBeClickable(btnContinueShopping));
        btnContinueShopping.click();
    }

    private void selectColorProduct(String color) throws InterruptedException {
        if(color.equalsIgnoreCase("blanco")){
            radioButtonWhite.click();
        } else if (color.equalsIgnoreCase("negro")) {
            radioButtonBlack.click();
        }
    }

    private void selectCaracteristic(String caracteristic,String value) throws InterruptedException {
        Select select;
        switch (caracteristic.toLowerCase()){
            case "talla":
                wait.until(ExpectedConditions.visibilityOfAllElements(selectSize));
                select = new Select(selectSize);
                select.selectByVisibleText(value);
                break;
            case "dimension":
                wait.until(ExpectedConditions.visibilityOfAllElements(selectDimention));
                select = new Select(selectDimention);
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
        inputamount.clear();
        inputamount.sendKeys(amount);
    }
}
