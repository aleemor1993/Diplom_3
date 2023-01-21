import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.AccountPage;
import pom.LoginPage;

import java.time.Duration;

import static steps.LoginSteps.loginGeneric;

@RunWith(Parameterized.class)
public class ToPersonalAccountTest {

    private String startUrl;

    private final By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public ToPersonalAccountTest(String startUrl){
        this.startUrl = startUrl;

    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {"https://stellarburgers.nomoreparties.site/register"},
                {"https://stellarburgers.nomoreparties.site/login"},
                {"https://stellarburgers.nomoreparties.site/feed"},
                {"https://stellarburgers.nomoreparties.site/"},
                {"https://stellarburgers.nomoreparties.site/forgot-password"},
        };
    }

    @Test
    public void toPersonalAccountByNotLoggedUser(){

        WebDriver driver = browserRule.getDriver();

        driver.get(startUrl);

        driver.findElement(personalAccountButton).click();

        LoginPage loginPage = new LoginPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(loginPage.getLoginHeader())));

        Assert.assertEquals(loginPage.returnLoginUrl(), driver.getCurrentUrl());

    }

    @Test
    public void toPersonalAccountByLoggedUser() throws InterruptedException {

        WebDriver driver = browserRule.getDriver();

        loginGeneric(driver);

        Thread.sleep(1000);

        driver.get(startUrl);

        Thread.sleep(1000);

        driver.findElement(personalAccountButton).click();

        AccountPage accountPage = new AccountPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(accountPage.getTextProfile())));

        Assert.assertEquals(accountPage.getUrl(), driver.getCurrentUrl());

    }
 }
