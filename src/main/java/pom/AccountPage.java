package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/account/profile";

    private final By textProfile = By.xpath(".//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9' and text()='Профиль']");

    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTextProfile() {
        return textProfile;
    }

    public String getUrl() {
        return url;
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }
}
