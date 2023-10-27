package co.dlacademy.stepsdefinitions;

import co.dlacademy.drivermager.FileReaderManager;
import co.dlacademy.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SelectProductoStep {

    protected WebDriver driver;

    private HomePage homePage;

    @Given("Que el usuario esta en la pagina principal")
    public void que_el_usuario_esta_en_la_pagina_principal() {
        driver = Hooks.webDriverManager.getDriver();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    @When("Selecciona un producto")
    public void seleccionaUnProducto() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage = new HomePage(driver);
        homePage.clickEnLupa();
        Thread.sleep(5000);
    }
    @When("Selecciona su <dim>, <color> y <cantidad>")
    public void seleccionaSuDimColorYCantidad() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("test");
    }
    @When("El usuario agrega el producto al carrito")
    public void elUsuarioAgregaElProductoAlCarrito() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("test");
    }
    @Then("verifica que el producto fue anadido al carrito")
    public void verificaQueElProductoFueAnadidoAlCarrito() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("test");
    }


}
