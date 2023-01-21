import main.BrowserRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.AccountPage;
import pom.MainPage;

import java.time.Duration;

import static steps.LoginSteps.chooseLoginFirstStep;
import static steps.LoginSteps.loginGeneric;

@RunWith(Parameterized.class)
public class LoginTest {

    int addressButton;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public LoginTest(int addressButton){
        this.addressButton = addressButton;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4},
        };
    }

    @Test
    public void loginByDifferentButtons() throws InterruptedException {

        WebDriver driver = browserRule.getDriver();

        chooseLoginFirstStep(driver, addressButton);

        loginGeneric(driver);
        Thread.sleep(1000);

        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement
                        (mainPage.getConstructorButton())));

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());

        mainPage.clickPersonalAccountButton();

        AccountPage accountPage = new AccountPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(accountPage.getTextProfile())));

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile", driver.getCurrentUrl());
    }
}
