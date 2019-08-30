package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage{

    WebElement item;
    WebElement shoppingCart;
    WebElement ratingRadio;
    WebElement submitButton;
    WebElement reviewTab;
    WebElement alert;
    WebElement quantityField;
    WebElement compareProductButton;


    public CartPage (WebDriver driver){
        super(driver);
    }

    private void addItemToCart() {
        By locator = By.cssSelector(".button-group > button");
        item = waitForElementVisibility(driver.findElement(locator));
        this.clickVisibleElement(item);
    }

    private void openCart() {
        driver.findElement(By.linkText("Shopping Cart"));
    }

    private void deleteItem() {
        By locator = By.cssSelector(".input-group-btn .btn-danger");
        this.waitForElementVisibility(driver.findElement(locator));
        this.clickVisibleElement(driver.findElement(locator));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        driver.findElement(By.cssSelector(".input-group-btn .btn-danger")).click();
    }
}
