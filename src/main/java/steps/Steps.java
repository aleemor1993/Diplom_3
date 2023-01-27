package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pom.*;

import static main.BaseURI.*;
import static main.UserGenerator.PASSWORD;
import static main.UserGenerator.generic;

public class Steps {

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

    public static void loginGeneric(WebDriver driver){

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.open();

        Assert.assertEquals(LOGIN, driver.getCurrentUrl());

        loginPage.clickEmailLabel();
        loginPage.fillEmailField(generic());
        loginPage.clickPasswordLabel();
        loginPage.fillPasswordField(PASSWORD);

        loginPage.clickLoginButton();
        driver.findElement(mainPage.getConstructorButton());

    }

    public static void downloadingPages(WebDriver driver, String page){

        switch (page) {
            case REGISTER:
                RegisterPage registerPage = new RegisterPage(driver);
                driver.findElement(registerPage.getLoginOnRegisterButton());
                break;
            case LOGIN:
                LoginPage loginPage = new LoginPage(driver);
                driver.findElement(loginPage.getLoginHeader());
            case MAIN:
                MainPage mainPage = new MainPage(driver);
                driver.findElement(mainPage.getConstructorButton());
                break;
            default:
                FeedPage feedPage = new FeedPage(driver);
                driver.findElement(feedPage.getFeedHeader());
                break;
        }
    }

}
