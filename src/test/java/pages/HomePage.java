package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Helpers;

public class HomePage {

    WebDriver driver;

    private final By serachInput = By.name("search");
    private final By serachButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private final By firstProduct = By.xpath("(//div[contains(@class, 'product-thumb')]//h4/a)[1]");
    
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProducto(String nombreProducto) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(serachInput));
        driver.findElement(serachInput).sendKeys(nombreProducto);
        Helpers.waitElementAndClick(driver, serachButton, 10);
    }

    public void selectFirstProduct(){
        Helpers.waitElementAndClick(driver, firstProduct, 10);
   }



}
