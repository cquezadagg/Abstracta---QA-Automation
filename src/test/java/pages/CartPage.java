package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Helpers;

public class CartPage {
   WebDriver driver;

   private final By addToCartButton = By.id("button-cart");
   private final By cartButton = By.id("cart");
   private final By viewCartButton = By.xpath("//strong[contains(text(),' View')]");
   private final By cartItem = By.xpath("//div[@id='content']//tbody/tr/td[2]");
   private final By removeButton = By.xpath("//button[@data-original-title='Remove']");
   private final By emptyCartMessage = By.xpath("//div[@id='content']/p[contains(text(), 'Your shopping cart is empty')]");

   public CartPage(WebDriver driver) {
       this.driver = driver;
   }

   public void addToCartProduct(){
        Helpers.waitElementAndClick(driver, addToCartButton, 10);
   }

   public void selectCartButton(){
        Helpers.waitElementAndClick(driver, cartButton, 10);
   }

   public void clickViewCartButton(){
        Helpers.waitElementAndClick(driver, viewCartButton, 10);
   }

   public void verifyItemInCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        String itemText = driver.findElement(cartItem).getText();
        assertTrue("El iphone no esta en el carrito", itemText.contains("iPhone"));
   }

   public void removeItemFromCart() {
        Helpers.waitElementAndClick(driver, removeButton, 10);
   }

   public void verifyCartIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
        String message = driver.findElement(emptyCartMessage).getText();
        assertEquals("El carrito no esta vacio", "Your shopping cart is empty!", message);
   }
}