import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.MainPage;

import static main.BaseURI.*;
import static steps.Steps.loginGeneric;

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
                {REGISTER},
                {LOGIN},
                {FEED},
                {MAIN},
                {FORGOT},
                {PROFILE},
        };
    }

    @Test
    public void clickConstructorTest() {

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);

        if (!(PROFILE.equals(startPage))) {
        driver.get(startPage);
        } else {

            loginGeneric(driver);
            mainPage.clickPersonalAccountButton();

        }

        mainPage.clickConstructorButton();

        Assert.assertEquals(mainPage.getUrl(),driver.getCurrentUrl());

    }

    @Test
    public void clickLogoTest(){

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);

        if (!(PROFILE.equals(startPage))) {
            driver.get(startPage);
        } else {

            loginGeneric(driver);
            mainPage.clickPersonalAccountButton();

        }
        mainPage.clickLogo();

        Assert.assertEquals(mainPage.getUrl(),driver.getCurrentUrl());

    }
}
