import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;

import java.time.Duration;

public class ConstructorTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void clickOnSauceSection(){

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickOnSauces();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement
                        (mainPage.getActiveTabSauces())));

    }

    @Test
    public void clickOnFillingSection(){

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickOnFillings();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement
                        (mainPage.getActiveTabFillings())));

    }

    @Test
    public void clickOnBunsSection(){

        WebDriver driver = browserRule.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickOnSauces();

        mainPage.clickOnBuns();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement
                        (mainPage.getActiveTabBuns())));

    }

}
