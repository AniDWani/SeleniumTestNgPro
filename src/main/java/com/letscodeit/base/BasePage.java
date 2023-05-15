package com.letscodeit.base;

import org.openqa.selenium.WebDriver;

public class BasePage extends CustomDriver{
    WebDriver driver;

    public BasePage(WebDriver driver){
        super();
        this.driver = driver;
    }

    public boolean verifyTitle(String expectedTitle){

        return driver.getTitle().equalsIgnoreCase(expectedTitle);
    }
}
