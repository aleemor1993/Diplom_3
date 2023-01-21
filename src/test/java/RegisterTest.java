import api.requests.LoginUser;
import api.UserAssertions;
import api.UserClient;
import io.restassured.response.ValidatableResponse;
import main.UserGenerator;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import main.BrowserRule;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.LoginPage;
import pom.RegisterPage;

import java.time.Duration;

public class RegisterTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    private final UserClient client = new UserClient();

    private final UserAssertions check = new UserAssertions();
    private String newEmail;

    //метка успешного создания пользователя
    private boolean registered = false;

    @Test
    public void registerNewUserSuccessfully() throws InterruptedException {
        WebDriver driver = browserRule.getDriver();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.open();

        //заполнение поля Имя
        registerPage.clickNameLabel();
        registerPage.fillNameField();

        Thread.sleep(3000);
        //генерация нового почтового адреса
        newEmail = UserGenerator.generateUserEmail();

        //заполнение поля Email
        registerPage.clickEmailLabel();
        registerPage.fillEmailField(newEmail);

        Thread.sleep(3000);

        //заполнение поля Пароль
        registerPage.clickPasswordLabel();
        registerPage.fillPasswordField();

        Thread.sleep(3000);

        //нажатие кнопки Зарегистрироваться
        registerPage.clickRegistrationButton();

        LoginPage loginPage = new LoginPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(loginPage.getLoginHeader())));

        Assert.assertEquals(driver.getCurrentUrl(), "https://stellarburgers.nomoreparties.site/login");

        registered = true;
    }

    @Test
    public void registerNewUserWithIncorrectPassword() throws InterruptedException {
        WebDriver driver = browserRule.getDriver();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.open();

        //заполнение поля Имя
        registerPage.clickNameLabel();
        registerPage.fillNameField();

        Thread.sleep(3000);
        //генерация нового почтового адреса
        newEmail = UserGenerator.generateUserEmail();

        //заполнение поля Email
        registerPage.clickEmailLabel();
        registerPage.fillEmailField(newEmail);

        Thread.sleep(3000);

        //заполнение поля Пароль
        registerPage.clickPasswordLabel();
        registerPage.fillPasswordFieldWithWrongPassword();

        Thread.sleep(3000);

        registerPage.clickRegistrationButton();

        Assert.assertTrue(driver.findElement(registerPage.getIncorrectPasswordMessage()).isDisplayed());

        //нажатие кнопки Зарегистрироваться
        registerPage.clickRegistrationButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void deleteRegisteredUsers(){

        if (registered){
            try {
                LoginUser loginUser = new LoginUser(newEmail, "111111");
                String accessToken = check.getValidAccessToken(client.login(loginUser));

                ValidatableResponse response = client.deleteUserSuccessfully(accessToken, newEmail);
                check.deleteUserSuccessfully(response);
            }
            catch (Exception e){
                System.out.println("Ошибка удаления пользователя");
            }
        }
    }
}
