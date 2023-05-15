package com.letscodeit.pageclasses;

import com.letscodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import utilities.Util;

import java.time.Duration;

public class Navigationpage extends BasePage {

    public Navigationpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public WebDriver driver;
    private final String URL = "https://lerarn.letscodeit.com/courses";
    private String ALL_COURSES_LINK = "//a[contains(text(),'All Courses')]";
    private String MY_COURSES_LINK = "//a[contains(text(),'MY Courses')]";
    private String ACCOUNT_ICON = "gravatar";
    private String Login_Link = "xpath=>//a[@href='/sign_in']";
    private String LOGOUT_LINK = "//a[href='sign-out']";
    private JavascriptExecutor js;

    //METHODS

    public void allCourses() {
        driver.findElement(By.xpath(ALL_COURSES_LINK)).click();
    }

    public void myCourses() {
        driver.findElement(By.xpath(MY_COURSES_LINK)).click();

    }

    public boolean isUserLoggedIn() {
        try {
            WebElement accountImage = driver.findElement(By.className(ACCOUNT_ICON));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean verifyHeader(){
        WebElement link  = driver.findElement(By.xpath(ALL_COURSES_LINK));
        String text = link.getText();
        return Util.verifyTextContains(text, "All Courses");

    }

    public LoginPage login() {

        driver.findElement(By.xpath(Login_Link)).click();
        return new LoginPage(driver);
    }


    public void logout() {
        driver.findElement(By.className(ACCOUNT_ICON)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement logoutLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(LOGOUT_LINK)));

        //logoutLink.click();
          js.executeScript("arguments[0].click();",logoutLink);

    }

}
