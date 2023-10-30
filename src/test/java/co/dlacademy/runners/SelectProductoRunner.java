package co.dlacademy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/seleccion_producto.feature",
        glue = "co.dlacademy.stepsdefinitions",
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SelectProductoRunner {
}
