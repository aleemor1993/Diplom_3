import main.BrowserRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.AccountPage;
import pom.LoginPage;
import pom.MainPage;

import static steps.Steps.loginGeneric;

public class LogoutTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Before
    public void login() {
        WebDriver driver = browserRule.getDriver();
        loginGeneric(driver);
    }

    @Test
    public void logout(){

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccountButton();

        accountPage.clickLogoutButton();

        loginPage.clickPersonalAccountButton();

        Assert.assertEquals("Вход", driver.findElement(loginPage.getLoginHeader()).getText());

    }
}
