package steps;

import utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class SearchSteps {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @Given("busco el producto {string}")
    public void buscoElProducto(String producto) throws InterruptedException {
        homePage.searchProducto(producto);
    }

    @When("selecciono el primer producto")
    public void seleccionoElPrimerProducto() {
        homePage.selectFirstProduct();
    }
}