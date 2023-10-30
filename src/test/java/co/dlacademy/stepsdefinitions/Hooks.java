package co.dlacademy.stepsdefinitions;

import co.dlacademy.drivermager.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hooks {
    public static WebDriverManager webDriverManager;

    @Before
    public void initDriver()  {
        webDriverManager =  new WebDriverManager();
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) webDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(" Faild Screenshot",new ByteArrayInputStream(sourcePath));
            //scenario.attach(sourcePath, "image/png", screenshotName);
        }
        webDriverManager.closeDriver();
    }
}