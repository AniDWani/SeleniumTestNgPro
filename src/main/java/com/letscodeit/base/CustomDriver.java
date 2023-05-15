package com.letscodeit.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomDriver {
    public WebDriver driver;
    private JavascriptExecutor js;

    public CustomDriver() {

    }

    public CustomDriver(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void refresh() {
        driver.navigate().refresh();
        System.out.println("The current browser location was refreshed");

    }

    public String getTitle() {
        String title = driver.getTitle();
        System.out.println("Title of the page is : " + title);
        return title;

    }
    //return current browser url
    public String getURL() {
    String url = driver.getCurrentUrl();
        System.out.println("Current URL is :: " +url);
        return url;
}
    //Navigate browser back
    public void navigateBrowserBack(){

        driver.navigate().back();
        System.out.println("Navigate Back");

    }

    public By getByType(String locator) {
        By by = null;
        String locatorType = locator.split("=>")[0];
        locator = locator.split("=>")[1];

        try {
            if (locatorType.contains("id")) {
                by = By.id(locator);
            } else if (locatorType.contains("name")) {
                by = By.name(locator);
        }
    }catch(
    Exception e)

    {
        System.out.println("By type not found with :" + locatorType);

    }


     //   public WebElement getElement Object String,SystemColorinfo(String locator, String info) {
        WebElement element = null;
        By byType = getByType(locator);
        try {
            element = (WebElement) driver.findElements(byType);
            System.out.println("Element Found With : " + locator);
        } catch (Exception e) {
            System.out.println("Element Not Found With : " + locator);
            e.printStackTrace();
        }
        return (By) element;
    }


}

