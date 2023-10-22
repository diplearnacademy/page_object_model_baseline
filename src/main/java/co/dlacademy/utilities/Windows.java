package co.dlacademy.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Windows {


    public static void changeWindowNew(WebDriver driver, WebElement element){

        String originalWindow = driver.getWindowHandle();
        element.click();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfWindowsToBe(2));

        for(String windowHadle: driver.getWindowHandles()){
            if(!originalWindow.contentEquals(windowHadle)){
                driver.switchTo().window(windowHadle);
                break;
            }
        }

    }
}
