package co.dlacademy.pages;

import co.dlacademy.utilities.FormatNumber;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailsReserve  extends  BasePage{

    By closedPupop = By.xpath("//div[@data-testid='modal-container']/.//button[@aria-label='Cerrar']");

    By reserveButton = By.xpath("//button[@data-testid='homes-pdp-cta-btn']/span");


    public DetailsReserve(WebDriver driver) {
        super(driver);
    }


    public void closedPoup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            WebElement poup = driver.findElement(closedPupop);
            wait.until(ExpectedConditions.visibilityOf(poup));
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click()",poup);
        }catch (NoSuchElementException e){
            System.out.println("popu no es visible ");
        }

    }

    public double getValueReserve(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement label = driver.findElement(By.xpath("//div[text()='Total sin incluir impuestos']"));
        wait.until(ExpectedConditions.visibilityOf(label));
        By costReserve = RelativeLocator.with(By.className("_j1kt73")).toRightOf(label);
        System.out.println(driver.findElement(costReserve).getText());
        return FormatNumber.converStrinDouble(driver.findElement(costReserve).getText());
    }


    public  void reserve(){
        //driver.findElement(reserveButton).click();
        WebElement reserve = driver.findElement(reserveButton);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()",reserve);
    }
}
