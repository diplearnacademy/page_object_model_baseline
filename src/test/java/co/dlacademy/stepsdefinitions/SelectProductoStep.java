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
        throw new io.cucumber.java.PendingException();
    }

}
