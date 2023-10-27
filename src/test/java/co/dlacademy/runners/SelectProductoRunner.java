package co.dlacademy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/seleccion_producto.feature",
        glue = "co.dlacademy.stepsdefinitions",
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SelectProductoRunner {
}
