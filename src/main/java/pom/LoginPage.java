package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.BaseURI.LOGIN;

public class LoginPage {

    WebDriver driver;

    private final String url = LOGIN;

    private final By loginHeader = By.xpath(".//h2[text()='Вход']");

    private final By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");


    private final By emailLabel = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']");

    private final By passwordLabel = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Пароль']");

    private final By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='name']");

    private final By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");

    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public String returnLoginUrl(){
        return url;
    }

    public By getLoginHeader(){
        return loginHeader;
    }

    public void clickEmailLabel(){
        driver.findElement(emailLabel).click();
    }

    public void fillEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickPasswordLabel(){
        driver.findElement(passwordLabel).click();
    }

    public void fillPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

}
