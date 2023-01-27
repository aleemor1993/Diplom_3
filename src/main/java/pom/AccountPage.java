package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.BaseURI.PROFILE;

public class AccountPage {

    WebDriver driver;

    private final String url = PROFILE;

    private final By textProfile = By.xpath(".//a[text()='Профиль']");

    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    private final By email = By.name("name");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTextProfile() {
        return textProfile;
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

    public By getPersonalAccountButton() {
        return personalAccountButton;
    }

    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    public String getEmailValue(){
        return driver.findElement(email).getAttribute("value");
    }

    public By getLogoutButton() {
        return logoutButton;
    }
}
