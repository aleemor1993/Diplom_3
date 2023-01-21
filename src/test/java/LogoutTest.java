import main.BrowserRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.AccountPage;
import pom.LoginPage;
import pom.MainPage;

import java.time.Duration;

import static steps.LoginSteps.loginGeneric;

public class LogoutTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Before
    public void login() throws InterruptedException {
        WebDriver driver = browserRule.getDriver();
        loginGeneric(driver);
    }

    @Test
    public void logout(){

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.clickPersonalAccountButton();

        AccountPage accountPage = new AccountPage(driver);

        accountPage.clickLogoutButton();

        LoginPage loginPage = new LoginPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(loginPage.getLoginHeader())));

        loginPage.clickPersonalAccountButton();

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());

    }
}
