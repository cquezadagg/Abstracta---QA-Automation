package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utils.DriverManager;

public class CartSteps {
   CartPage cartPage = new CartPage(DriverManager.getDriver()); 


   @And("agrego el producto iPhone al carrito")
   public void agregoElProductoAlCarrito() {
       cartPage.addToCartProduct();
   }

   @And("hago click en el boton del carrito superior")
   public void hagoClickEnElBotonDelCarritoSuperior() {
       cartPage.selectCartButton();
   }

   @And("selecciono el boton View Cart")
   public void seleccionoElBotonVerCarrito() {
       cartPage.clickViewCartButton();
   }

   @Then("valido que el producto iPhone este en el carrito")
   public void validoQueElProductoEsteEnElCarrito() {
       cartPage.verifyItemInCart();
   }

   @When("remuevo el producto del carrito")
   public void remuevoElProductoDelCarrito() {
       cartPage.removeItemFromCart();
   }
   
   @And("valido que el producto iPhone no este en el carrito")
   public void validoQueElProductoNoEsteEnElCarrito() {
       cartPage.verifyCartIsEmpty();
   }
}
