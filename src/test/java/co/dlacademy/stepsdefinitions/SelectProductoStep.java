package co.dlacademy.stepsdefinitions;

import co.dlacademy.drivermager.FileReaderManager;
import co.dlacademy.pages.HomePage;
import co.dlacademy.pages.ProductModalPage;
import co.dlacademy.pages.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Strings;

import java.util.List;
import java.util.Map;

public class SelectProductoStep {

    protected WebDriver driver;

    private HomePage homePage;
    private ProductModalPage productModalPage;

    private ShoppingCartPage shoppingCartPage;

    private  List<Map<String,String >> listProducts;

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
        Assert.assertTrue(false);
    }


    @When("Agrega los productos con sus caracteristicas al carrito")
    public void agregaLosProductosConSusCaracteristicasAlCarrito(List<Map<String,String>> products) throws InterruptedException {
        homePage = new HomePage(driver);
        productModalPage = new ProductModalPage(driver);
        listProducts = products;
        for (Map<String,String> product:products) {
            homePage.selectProduct(product.get("Producto"));
            productModalPage.selectAmount(product.get("Cantidad"));
            productModalPage.SelectCaracteristics(product.get("caracteristicas"));
            productModalPage.addProductCar();
            productModalPage.continueShopping();
        }
    }

    @Then("verifica que los productos fueron agregados al carrito")
    public void verificaQueLosProductosFueronAgregadosAlCarrito() {
        shoppingCartPage = new ShoppingCartPage(driver);
        homePage.openShoppingCar();
        for (Map<String,String> product:listProducts) {
            Assert.assertTrue(shoppingCartPage.productNamePresent(product.get("Producto")));
        }
    }
}
