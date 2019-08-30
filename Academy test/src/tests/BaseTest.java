package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class BaseTest{

    public WebDriver driver;

    public BaseTest () {
        this.driver = new ChromeDriver();
    }

    public BaseTest (WebDriver driver) {
        this.driver = driver;
    }

    @BeforeTest
    public void setUp(){
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
