package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.ForgotPasswordPage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import java.time.Duration;

import static main.UserGenerator.generic;

public class LoginSteps {

    public static void chooseLoginFirstStep(WebDriver driver, int page){

        switch (page) {
            case 1: MainPage mainPage1 = new MainPage(driver);
                    mainPage1.open();
                    mainPage1.clickEnterIntoAccountButton();
                break;
            case 2: MainPage mainPage2 = new MainPage(driver);
                    mainPage2.open();
                    mainPage2.clickPersonalAccountButton();
                break;
            case 3: RegisterPage registerPage = new RegisterPage(driver);
                    registerPage.open();
                    registerPage.clickLoginOnRegistrationButton();
                break;
            default:
                    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
                    forgotPasswordPage.open();
                    forgotPasswordPage.clickResetPasswordLoginButton();
                break;
        }
    }

    public static void loginGeneric(WebDriver driver) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(loginPage.getLoginHeader())));

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());

        loginPage.clickEmailLabel();
        loginPage.fillEmailField(generic());
        loginPage.clickPasswordLabel();
        loginPage.fillPasswordField("111111");

        Thread.sleep(1000);
        loginPage.clickLoginButton();
    }


}
