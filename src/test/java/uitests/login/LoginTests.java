package uitests.login;

import org.example.uitests.pages.login.LoginPage;
import org.example.uitests.pages.main.MainPage;
import org.example.uitests.utils.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uitests.BaseTests;

public class LoginTests extends BaseTests {
    String userName = ConfigProvider.getInstance().getProperty("login.tests.username");
    String userPassword = ConfigProvider.getInstance().getProperty("login.tests.password");

    @BeforeMethod
    public void beforeMethod() {
        goToPart("login");
    }

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(userName, userPassword);

        Assert.assertEquals(mainPage.getSuccessMessageText().trim(), "You logged into a secure area!\n" + "×");
    }

    @Test
    public void unsuccessfulLogin() {
        LoginPage loginPage = new LoginPage()
                .unsuccessfulLogin(userName, userPassword);

        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
    }

}