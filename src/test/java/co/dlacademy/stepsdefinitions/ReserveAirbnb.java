package co.dlacademy.stepsdefinitions;

import co.dlacademy.drivermager.FileReaderManager;
import co.dlacademy.drivermager.WebDriverManager;
import co.dlacademy.pages.ConfirmPayPage;
import co.dlacademy.pages.DetailsReserve;
import co.dlacademy.pages.HomePage;
import co.dlacademy.pages.ResultSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ReserveAirbnb{

    protected WebDriver driver;
    //protected  WebDriverManager webDriverManager;

    private HomePage homePage;
    private ResultSearchPage resultSearchPage;

    private DetailsReserve detailsReserve;

    private ConfirmPayPage confirmPayPage;

    @Given("que Bryan se encuentra en la pagina de Airbnb")
    public void que_bryan_se_encuentra_en_la_pagina_de_airbnb() {
        driver = Hooks.webDriverManager.getDriver();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());


    }
    @When("busca una estancia en la ciudad de {string}")
    public void busca_una_estancia_en_la_ciudad_de(String city) {
        homePage = new HomePage(driver);
        homePage.opensearch();
        homePage.selectCity(city);

    }
    @When("seleciona las fechas de estancia  del {string} hasta el {string}")
    public void seleciona_las_fechas_de_estancia_del_hasta_el(String startDate, String endDate) {
         homePage.selectDate2(startDate);
         homePage.selectDate2(endDate);

    }
    @When("especifica una ocupacion para {int} {string}")
    public void especifica_una_ocupacion_para(Integer numGuests, String typeGuest) {
        homePage.selectNumberTypeGuests(numGuests,typeGuest);

    }
    @When("elige la primera opcion mostrada en la reseva")
    public void elige_la_primera_opcion_mostrada_en_la_reseva() {
         homePage.searchResult();

    }
    @Then("puede ver el precio correspondiente a la estancia reservada")
    public void puede_ver_el_precio_correspondiente_a_la_estancia_reservada() {
       resultSearchPage = new ResultSearchPage(driver);
       detailsReserve = new DetailsReserve(driver);
       confirmPayPage = new ConfirmPayPage(driver);
       resultSearchPage.selectFirstResult();
       detailsReserve.closedPoup();
       double priceReserve = detailsReserve.getValueReserve();
        System.out.println(priceReserve);
       detailsReserve.reserve();
       double payPrice = confirmPayPage.getPayPrice();
        Assertions.assertEquals(priceReserve,payPrice);

    }

    @Given("practica de la nueva pagina")
    public void practicaDeLaNuevaPagina() throws InterruptedException {
        //model //div[@class='modal-body']/.//p[@class='product-price']
        driver = Hooks.webDriverManager.getDriver();
        driver.get("http://teststore.automationtesting.co.uk/");
        WebElement producto = driver.findElement(By.xpath("(//div[@class='product-description'])[1]"));
        Actions acciones = new Actions(driver);
        acciones.moveToElement(producto).perform();
        driver.findElement(By.xpath("(//a[@data-link-action='quickview'])[1]")).click();
        Thread.sleep(10000);


    }
}
