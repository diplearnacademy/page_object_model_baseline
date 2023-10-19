package co.dlacademy;

import co.dlacademy.drivermager.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverManager webDriverManager;

    @BeforeEach
    void setup(){
       /* System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com.co/");*/

        webDriverManager =  new WebDriverManager();
        driver = webDriverManager.getDriver();
        driver.get("https://www.airbnb.com.co/");
    }
}
