package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductPage;


public class ProductTest{

    ProductPage product;

    public ProductTest () {
        product= new ProductPage(new ChromeDriver());
    }

    @BeforeTest
    public void setUp(){
        product.driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        product.driver.close();
    }

    @Test
    public void addAReviewSuccessfullyTest(){
        product.openWeb("http://opencart.abstracta.us/index.php?route=product/product&product_id=40");
        product.openReviews();
        product.fillReviewForm("text of 25 characters or more");
        product.submitForm();
        assertAddReview("success", "Thank you");
    }

    @Test
    public void AddAReviewWithErrorTest(){
        product.openWeb("http://opencart.abstracta.us/index.php?route=product/product&product_id=40");
        product.openReviews();
        product.fillReviewForm("test");
        product.submitForm();
        assertAddReview("danger", "Warning");
    }

    private void assertAddReview (String alertType, String expected){
        String alertText = product.getAlertText(alertType);
        Assert.assertTrue(alertText.contains(expected));
    }
}
