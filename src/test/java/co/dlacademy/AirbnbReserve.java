package co.dlacademy;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AirbnbReserve extends  BaseTest{


    @Test
    void reserve() throws InterruptedException {

        WebElement openSearch =  driver.findElement(By.xpath("//div[@data-testid='little-search']/span/button/div[text()='En cualquier lugar del mundo']/.."));

        if (openSearch.isDisplayed()){
            openSearch.click();
        }

        WebElement selectPlace = driver.findElement(By.xpath("//input[@data-testid='structured-search-input-field-query']"));
        selectPlace.sendKeys("Santa marta");
        selectPlace.sendKeys(Keys.ENTER);

        //selecionar fechas inicial
        WebElement startDate = driver.findElement(By.xpath("//div[@aria-label='Calendario']/.//h2[text()='Diciembre 2023']/ancestor::div[@data-visible]"));
        System.out.println(startDate.getAttribute("data-visible"));

        while (!startDate.getAttribute("data-visible").equals("true")){
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@aria-label='Haz clic en la flecha de la derecha para cambiar al mes siguiente.']")).click();
        }

        driver.findElement(By.xpath("//td/div[contains(@data-testid,'15/12')]")).click();

        // fecha final
        WebElement endDate = driver.findElement(By.xpath("//div[@aria-label='Calendario']/.//h2[text()='Diciembre 2023']/ancestor::div[@data-visible]"));
        System.out.println(startDate.getAttribute("data-visible"));

        while (!endDate.getAttribute("data-visible").equals("true")){
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@aria-label='Haz clic en la flecha de la derecha para cambiar al mes siguiente.']")).click();
        }

        driver.findElement(By.xpath("//td/div[contains(@data-testid,'30/12')]")).click();


        // selecionar numero personas

        driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-guests-button']")).click();


        int numAdult = 3;
        for (int i = 0; i < numAdult ; i++) {
            driver.findElement(By.xpath("//button[@data-testid='stepper-adults-increase-button']")).click();
        }







    }
}
