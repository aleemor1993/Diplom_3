import api.requests.DeleteUser;
import api.requests.LoginUser;
import api.UserAssertions;
import api.UserClient;
import io.restassured.response.ValidatableResponse;
import main.UserGenerator;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import main.BrowserRule;
import pom.LoginPage;
import pom.RegisterPage;

import static main.BaseURI.REGISTER;
import static main.UserGenerator.PASSWORD;

public class RegisterTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    private final UserClient client = new UserClient();

    private final UserAssertions check = new UserAssertions();
    private String newEmail;

    //метка успешного создания пользователя
    private boolean registered = false;

    @Test
    public void registerNewUserSuccessfully() {

        WebDriver driver = browserRule.getDriver();
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        registerPage.open();

        //заполнение поля Имя
        registerPage.clickNameLabel();
        registerPage.fillNameField();

        //генерация нового почтового адреса
        newEmail = UserGenerator.generateUserEmail();

        //заполнение поля Email
        registerPage.clickEmailLabel();
        registerPage.fillEmailField(newEmail);

        //заполнение поля Пароль
        registerPage.clickPasswordLabel();
        registerPage.fillPasswordField();

        //нажатие кнопки Зарегистрироваться
        registerPage.clickRegistrationButton();

        registered = true;

        Assert.assertEquals("Вход", driver.findElement(loginPage.getLoginHeader()).getText());

    }

    @Test
    public void registerNewUserWithIncorrectPassword() {

        WebDriver driver = browserRule.getDriver();
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.open();

        //заполнение поля Имя
        registerPage.clickNameLabel();
        registerPage.fillNameField();

        //генерация нового почтового адреса
        newEmail = UserGenerator.generateUserEmail();

        //заполнение поля Email
        registerPage.clickEmailLabel();
        registerPage.fillEmailField(newEmail);

        //заполнение поля Пароль
        registerPage.clickPasswordLabel();
        registerPage.fillPasswordFieldWithWrongPassword();

        registerPage.clickRegistrationButton();

        Assert.assertTrue(driver.findElement(registerPage.getIncorrectPasswordMessage()).isDisplayed());

        //нажатие кнопки Зарегистрироваться
        registerPage.clickRegistrationButton();

        Assert.assertEquals(driver.getCurrentUrl(), REGISTER);
    }

    @After
    public void deleteRegisteredUsers(){

        if (registered){
            try {
                LoginUser loginUser = new LoginUser(newEmail, PASSWORD);
                String accessToken = check.getValidAccessToken(client.login(loginUser));

                ValidatableResponse response = client.deleteUserSuccessfully(accessToken, new DeleteUser(newEmail));
                check.deleteUserSuccessfully(response);
            }
            catch (Exception e){
                System.out.println("Ошибка удаления пользователя");
            }
        }
    }
}
