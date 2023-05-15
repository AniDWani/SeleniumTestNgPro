package com.letscodeit.baseTest;

import com.letscodeit.pageclasses.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;
    protected LoginPage login;
    protected String baseURL;
    protected Navigationpage nav;
    protected SearchBarPage search;
    protected ResultsPage result;
    protected CategoryFilterPage category;


    @BeforeClass
    public void CommonSetup() {
        driver = (WebDriver) WebDriverFactory.getInstance().getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        baseURL = "https://learn.letskodeit.com";
        driver.get(baseURL);
        nav = new Navigationpage(driver);
        login = nav.login();
    }

    @AfterClass
    public void CommontearDown() {
        driver.quit();
    }
}
