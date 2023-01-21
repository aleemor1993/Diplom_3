package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/register";

    private final By nameLabel = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Имя']");

    private final By emailLabel = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']");

    private final By passwordLabel = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Пароль']");

    private final By nameActiveField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@name ='name']");

    private final By emailActiveField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@name ='name']");

    private final By passwordActiveField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default input_status_active']/input[@name ='Пароль']");

    private final By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private final By incorrectPasswordMessage = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");

    private final By loginOnRegisterButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public void clickNameLabel(){
        driver.findElement(nameLabel).click();
    }

    public void fillNameField(){
        driver.findElement(nameActiveField).sendKeys("John John");
    }

    public void clickEmailLabel(){
        driver.findElement(emailLabel).click();
    }

    public void fillEmailField(String newEmail){
        driver.findElement(emailActiveField).sendKeys(newEmail);
    }

    public void clickPasswordLabel(){
        driver.findElement(passwordLabel).click();
    }

    public void fillPasswordField(){
        driver.findElement(passwordActiveField).sendKeys("111111");
    }

    public void fillPasswordFieldWithWrongPassword(){
        driver.findElement(passwordActiveField).sendKeys("11111");
    }

    public void clickRegistrationButton(){
        driver.findElement(registerButton).click();
    }

    public By getIncorrectPasswordMessage(){
        return incorrectPasswordMessage;
    }

    public void clickLoginOnRegistrationButton(){
        driver.findElement(loginOnRegisterButton).click();
    }

}
