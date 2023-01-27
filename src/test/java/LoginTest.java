import main.BrowserRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.AccountPage;
import pom.MainPage;

import static steps.Steps.chooseLoginFirstStep;
import static steps.Steps.loginGeneric;

@RunWith(Parameterized.class)
public class LoginTest {

    private int addressButton;

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
    public void loginByDifferentButtons() {

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        //переход на нужную страницу
        chooseLoginFirstStep(driver, addressButton);

        loginGeneric(driver);

        mainPage.clickPersonalAccountButton();

        Assert.assertEquals("Профиль", driver.findElement(accountPage.getTextProfile()).getText());

    }
}
