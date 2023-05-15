package testclasses;

import com.letscodeit.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @BeforeClass
    public void setup() {
    }


    @AfterMethod
    public void afterMethod() {
        if (nav.isUserLoggedIn()) {
            nav.logout();
            nav.login();
        }

    }

    @Test
    public void testLogin() {
        nav = login.signInWith("anitha.emmidi@gmail.com", "An1pricha");
        boolean result = nav.verifyHeader();
      //  boolean result = nav.isUserLoggedIn();
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidLogin() {
        nav = login.signInWith("anitha.emmidi@gmail.com", "An1pricha");
        boolean result = nav.isUserLoggedIn();
        Assert.assertFalse(result);


    }
}