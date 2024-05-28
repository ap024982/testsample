package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    By title= By.xpath("//span[contains(text(),'Products')]");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public boolean isHomeDisplayed(){
        try {
            return driver.findElement(title).isDisplayed();
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public void selectItem(String strItemName){
        By objProductName= By.xpath("//div[contains(text(),'"+strItemName+"')]");
        driver.findElement(objProductName).click();
    }


}
