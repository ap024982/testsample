package org.example;

import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pages.HomePage;
import org.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public WebDriver driver;
    private LoginPage objLogin;
    private HomePage objHome;
    /*public static void main (String [] args){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".submit-button btn_action")).click();

    }*/

    @Before
    public void initialize(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu"); // Optional: for better compatibility on some platforms
        options.addArguments("--window-size=1920,1080");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void validateLogin(){
      objLogin=new LoginPage(driver);
      objHome=new HomePage(driver);
      objLogin.enterUsername("standard_user");
      objLogin.enterPassword("secret_sauce");
      objLogin.clickLoginButton();
      Assert.assertTrue("Home Page is Displayed",objHome.isHomeDisplayed());
      objHome.selectItem("Sauce Labs Bike Light");
    }

    @Test
    public void validateInvalidLogin(){
        objLogin=new LoginPage(driver);
        objHome=new HomePage(driver);
        objLogin.enterUsername("st_user");
        objLogin.enterPassword("secret_uce");
        objLogin.clickLoginButton();
        Assert.assertTrue("Home Page is not Displayed",objHome.isHomeDisplayed());
    }

    @After
    public void teardown(){

    }


}
