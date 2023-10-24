package co.dlacademy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/reserve_airbnb.feature",
        glue = "co.dlacademy.stepsdefinitions"
)
public class ReserveRunner {
}
