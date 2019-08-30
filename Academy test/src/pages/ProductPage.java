package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{

    WebElement reviewName;
    WebElement reviewBody;
    WebElement ratingRadio;
    WebElement submitButton;
    WebElement reviewTab;
    WebElement alert;
    WebElement quantityField;
    WebElement compareProductButton;


    public ProductPage (WebDriver driver){
        super(driver);
    }

    public void openReviews (){
        reviewTab = driver.findElement(By.xpath("//*[contains(text(), 'Reviews')]"));
        this.waitForElementVisibility(reviewTab);
        this.reviewTab.click();
    }

    public void fillReviewForm (String body){
        reviewName = driver.findElement(By.id("input-name"));
        reviewBody = driver.findElement(By.id("input-review"));
        ratingRadio = driver.findElement(By.cssSelector("input[value='3']"));
        this.writeText(reviewName, "test name");
        this.writeText(reviewBody, body);
        this.clickVisibleElement(ratingRadio);
    }

    public void submitForm (){
        submitButton = driver.findElement(By.id("button-review"));
        this.clickVisibleElement(this.submitButton);
    }

    public String getAlertText (String alertType) {
        alert = waitForVisibilityOfElementLocated(By.cssSelector(".alert.alert-"+alertType));
        return this.readText(alert);
    }

    public void openProductPage (String menuName, String subcategoryName, String productName){
        WebElement menu = driver.findElement(By.linkText(menuName));
        this.clickVisibleElement(menu);
        WebElement subcategory = driver.findElement(By.partialLinkText(subcategoryName));
        this.clickVisibleElement(subcategory);
        WebElement product = driver.findElement(By.partialLinkText(productName));
        this.clickVisibleElement(product);
    }

    public void changeQuantity (String quantity){
        quantityField = driver.findElement(By.id("input-quantity"));
        this.quantityField.clear();
        this.writeText(quantityField, "10");
    }

    public void compareProduct (String menuName, String subcategoryName, String productName){
        compareProductButton = driver.findElement(By.cssSelector(".btn.btn-default:nth-child(2)"));
        openProductPage(menuName, subcategoryName, productName);
        clickVisibleElement(compareProductButton);
    }

    public void openWeb(String URL){
        this.driver.get(URL);
    }
}
