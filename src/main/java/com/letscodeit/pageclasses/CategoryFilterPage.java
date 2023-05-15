package com.letscodeit.pageclasses;

import com.letscodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryFilterPage extends BasePage {

    public CategoryFilterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public WebDriver driver;
    private JavascriptExecutor js;
    private String CATEGORY_DROPDOWN = ("//div[contains(@class,'course-filter')])[1]//button");
    private String CATEGORY_OPTION = "//a[@href='/courses/category/%s']";


    public  void clickCategoryDropdown(){
        //Find category dropdown

        WebElement categoryDropdown = driver.findElement(By.xpath(CATEGORY_DROPDOWN));
        categoryDropdown.click();

    }

    public WebElement findCategory(String categoryName) {

WebElement categoryDropdown = driver.findElement(By.xpath(CATEGORY_DROPDOWN));
        categoryDropdown.click();

        //wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement categoryOption = wait.until(
                ExpectedConditions.elementToBeClickable
                        (By.xpath(String.format(CATEGORY_OPTION,categoryName))));
        return categoryOption;
    }


        public ResultsPage select (String categoryName){
            WebElement categoryOption = findCategory(categoryName);
            //Used Javascript click because this was having issues with usual click method
            js.executeScript("arguments[0].click();", categoryOption);
            return new ResultsPage(driver);
        }

        public int findCoursesCount (String categoryName){

            WebElement categoryOption = findCategory(categoryName);

            //Get category text
            String categoryText = categoryOption.getText();
            //spit on symbol
            //Example:Software IT (2);
            //value of array temp[0] ->Software IT

            String[] arrayTemp = categoryText.split("\\(");

            String courseCountString = arrayTemp[1].split("\\)")[0];
            int courseCount = Integer.parseInt(courseCountString);

            //Click the dropdown  option to close the menu
            clickCategoryDropdown();
            return courseCount;


        }

    }

