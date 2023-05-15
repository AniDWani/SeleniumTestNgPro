package testclasses;

import com.letscodeit.baseTest.BaseTest;
import com.letscodeit.pageclasses.CategoryFilterPage;
import com.letscodeit.pageclasses.SearchBarPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllCoursesTests extends BaseTest {


    @BeforeClass
    public void setup() {

        nav = login.signInWith("anitha.emmidi@gmail.com", "An1pricha");
    }

    @Test
    public void verifySearchCourse() {
        nav.allCourses();
        search = new SearchBarPage(driver);
        result = search.course("rest api");
        boolean searchResult = result.verifySearchResult();
        Assert.assertTrue(searchResult);
    }


    @Test
    public void filterByCategory() {
        nav.allCourses();
        category = new CategoryFilterPage(driver);
        result = category.select("Software IT");
        int count = category.findCoursesCount("Software IT");
        boolean filterResult = result.verifyFilterCourseCount(count);
        Assert.assertTrue(filterResult);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
