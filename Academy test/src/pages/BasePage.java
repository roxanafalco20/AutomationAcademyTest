package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public WebElement waitForElementVisibility (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForVisibilityOfElementLocated (By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element);
    }

    public void clickVisibleElement (WebElement element){
        waitForElementVisibility(element);
        element.click();
    }

    public void writeText (WebElement element, String text){
        waitForElementVisibility(element);
        element.sendKeys(text);
    }

    public String readText (WebElement element){
        waitForElementVisibility(element);
        return element.getText();
    }

}
