import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;

import java.time.Duration;

import static steps.LoginSteps.loginGeneric;


//кейсы на переход на главную страницу по нажатию на Конструктор и лого
@RunWith(Parameterized.class)
public class ToMainPageTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    String startPage;

    public ToMainPageTest(String startPage){
        this.startPage = startPage;

    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {"https://stellarburgers.nomoreparties.site/register"},
                {"https://stellarburgers.nomoreparties.site/login"},
                {"https://stellarburgers.nomoreparties.site/feed"},
                {"https://stellarburgers.nomoreparties.site"},
                {"https://stellarburgers.nomoreparties.site/forgot-password"},
                {"https://stellarburgers.nomoreparties.site/account/profile"},
        };
    }

    @Test
    public void clickConstructorTest() throws InterruptedException {

        WebDriver driver = browserRule.getDriver();

        if (!("https://stellarburgers.nomoreparties.site/account/profile".equals(startPage))) {
        driver.get(startPage);
        } else {

            loginGeneric(driver);

            MainPage mainPage = new MainPage(driver);
            mainPage.clickPersonalAccountButton();

        }

        MainPage mainPage = new MainPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(mainPage.getConstructorButton())));

        mainPage.clickConstructorButton();

        Assert.assertEquals(mainPage.getUrl(),driver.getCurrentUrl());

    }

    @Test
    public void clickLogoTest() throws InterruptedException {

        WebDriver driver = browserRule.getDriver();

        if (!("https://stellarburgers.nomoreparties.site/account/profile".equals(startPage))) {
            driver.get(startPage);
        } else {

            loginGeneric(driver);

            MainPage mainPage = new MainPage(driver);
            mainPage.clickPersonalAccountButton();

        }

        MainPage mainPage = new MainPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(mainPage.getConstructorButton())));

        mainPage.clickLogo();

        Assert.assertEquals(mainPage.getUrl(),driver.getCurrentUrl());

    }
}
