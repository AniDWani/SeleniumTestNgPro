package com.letscodeit.pageclasses;

import com.letscodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver driver;

    private String EMAIL_FIELD = "user_email";
    private String PASSWORD_FIELD = "user_password";
    private String LOG_IN_BUTTON = "commit";



    public Navigationpage signInWith(String email, String password) {

        WebElement emailField = driver.findElement(By.id(EMAIL_FIELD));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement LoginButton = driver.findElement(By.name(LOG_IN_BUTTON));
        LoginButton.click();

        return new Navigationpage(driver);

    }

}

