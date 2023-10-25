package co.dlacademy.stepsdefinitions;

import co.dlacademy.drivermager.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    public static WebDriverManager webDriverManager;

    @Before
    public void initDriver(){
        webDriverManager = new WebDriverManager();
    }

    @After
    public void finishTest(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) webDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }



}
