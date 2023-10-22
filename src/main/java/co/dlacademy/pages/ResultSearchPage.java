package co.dlacademy.pages;


import co.dlacademy.utilities.Windows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultSearchPage extends BasePage {


    By firstElementResult  = By.xpath("(//div[@data-testid='card-container'])[1]");

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }


    public void selectFirstResult(){
        System.out.println(driver.getTitle());
        WebElement firstResult = driver.findElement(firstElementResult);
        Windows.changeWindowNew(driver,firstResult);
        System.out.println(driver.getTitle());
    }
}
