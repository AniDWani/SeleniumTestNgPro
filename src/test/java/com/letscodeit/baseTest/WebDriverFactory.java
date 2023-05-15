package com.letscodeit.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    //Singleton
    //Only one instance of the class can exist at a time
    private static final WebDriverFactory instance = new WebDriverFactory();

    private WebDriverFactory() {

    }

    public static WebDriverFactory getInstance() {
        return instance;
    }

    private static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(String browser) {
        WebDriver driver = null;
        try {
            If(browser.equalsIgnoreCase("FirefoxDriver"));
            {
                driver = new FirefoxDriver();
                threadedDriver.set(driver);
            }
            If(browser.equalsIgnoreCase("EdgeDriver"));
            {
                driver = new EdgeDriver();
                threadedDriver.set(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadedDriver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return threadedDriver.get();
    }

    private void If(boolean edgeDriver) {
    }
}
