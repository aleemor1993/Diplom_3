import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.*;

import static main.BaseURI.*;
import static main.UserGenerator.generic;
import static steps.Steps.*;

@RunWith(Parameterized.class)
public class ToPersonalAccountTest {

    private String startUrl;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public ToPersonalAccountTest(String startUrl){
        this.startUrl = startUrl;

    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {REGISTER},
                {LOGIN},
                {FEED},
                {MAIN},
        };
    }

    @Test
    public void toPersonalAccountByNotLoggedUser(){

        WebDriver driver = browserRule.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        driver.get(startUrl);

        //загрузка страниц
        downloadingPages(driver, startUrl);

        driver.findElement(accountPage.getPersonalAccountButton()).click();

        Assert.assertEquals("Вход", driver.findElement(loginPage.getLoginHeader()).getText());

    }

    @Test
    public void toPersonalAccountByLoggedUser(){

        WebDriver driver = browserRule.getDriver();
        AccountPage accountPage = new AccountPage(driver);

        loginGeneric(driver);

        driver.get(startUrl);

        //загрузка страниц
        downloadingPages(driver, startUrl);

        accountPage.clickPersonalAccountButton();

        Assert.assertEquals("Выход", driver.findElement(accountPage.getLogoutButton()).getText());

        Assert.assertEquals("Профиль", driver.findElement(accountPage.getTextProfile()).getText());

        Assert.assertEquals(generic(), accountPage.getEmailValue());

    }
 }
