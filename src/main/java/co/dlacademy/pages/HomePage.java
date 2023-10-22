package co.dlacademy.pages;

import co.dlacademy.utilities.Dates;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private By openSearch = By.xpath("//div[@data-testid='little-search']/span/button/div[text()='En cualquier lugar del mundo']/..");

    private By cityInput = By.xpath("//input[@data-testid='structured-search-input-field-query']");

    private By calander = By.xpath("//div[@aria-label='Calendario']");

    private By nextMonth = By.xpath("//button[@aria-label='Haz clic en la flecha de la derecha para cambiar al mes siguiente.']");

    private By numGuestsButton = By.xpath("//div[@data-testid='structured-search-input-field-guests-button']");

    private By increaseAdultButton = By.xpath("//button[@data-testid='stepper-adults-increase-button']");

    private By increaseChildrenButton = By.xpath("//button[@data-testid='stepper-children-increase-button']");

    private By increaseInfantsButton = By.xpath("//button[@data-testid='stepper-infants-increase-button']");

    private By increasePetsButton = By.xpath("//button[@data-testid='stepper-pets-increase-button']");


    private By searchResultButton = By.xpath("//button[@data-testid='structured-search-input-search-button']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private void selectday(String day, String month) {
        driver.findElement(calander).findElement(By.xpath(".//td/div[contains(@data-testid,'" + day + "/" + month + "')]")).click();
    }

    public void opensearch() {
        WebElement opensearchButton = driver.findElement(openSearch);
        if (opensearchButton.isDisplayed()) {
            opensearchButton.click();
        }
    }

    public void selectCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(cityInput).sendKeys(Keys.ENTER);
    }

    public void selectDate(String monthYear, String day) {
        // Octubre 2023
        String[] date = monthYear.split(" ");
        String month = date[0];
        String monthNumber = Dates.getNumberMonth(month);
        WebElement visibleMonth = driver.findElement(calander).findElement(By.xpath(".//h2[text()='" + monthYear + "']/ancestor::div[@data-visible]"));
        while (!visibleMonth.getAttribute("data-visible").equals("true")) {
            driver.findElement(nextMonth).click();
        }
        selectday(day, monthNumber);
    }

    //2 Diciembre 2023
    public void selectDate2(String date) {
        // Octubre 2023
        String[] datePart = date.split(" ");
        String day = datePart[0];
        String month = datePart[1];
        String monthYear = month + " " + datePart[2];
        String monthNumber = Dates.getNumberMonth(month);
        WebElement visibleMonth = driver.findElement(calander).findElement(By.xpath(".//h2[text()='" + monthYear + "']/ancestor::div[@data-visible]"));
        while (!visibleMonth.getAttribute("data-visible").equals("true")) {
            driver.findElement(nextMonth).click();
        }
        selectday(day, monthNumber);
    }


    public void selectNumberGuest(int adultGuest) {
        driver.findElement(numGuestsButton).click();
        for (int i = 0; i < adultGuest; i++) {
            driver.findElement(increaseAdultButton).click();
        }
    }

    private void increaseGuest(int guests, By buttonIncrease) {
        for (int i = 0; i < guests; i++) {
            driver.findElement(buttonIncrease).click();

        }

    }

    public void selectNumberTypeGuests(int numGuests, String typeGuest) {

        if (driver.findElement(numGuestsButton).getAttribute("aria-expanded").equals("false")) {
            driver.findElement(numGuestsButton).click();
        }

        switch (typeGuest.toLowerCase()) {
            case "adultos":
                increaseGuest(numGuests, increaseAdultButton);
                break;
            case "ninos":
                increaseGuest(numGuests, increaseChildrenButton);
                break;
            case "bebes":
                increaseGuest(numGuests, increaseInfantsButton);
                break;
            case "mascotas":
                increaseGuest(numGuests, increasePetsButton);
                break;
            default:
                System.out.println("opcion no valida " + typeGuest);

        }


    }

    public void searchResult() {
        driver.findElement(searchResultButton).click();
    }
}
