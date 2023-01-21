package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    private final By resetPasswordLoginButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public void clickResetPasswordLoginButton(){
        driver.findElement(resetPasswordLoginButton).click();
    }
}
