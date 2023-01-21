package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/";

    private final By enterIntoAccountButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");

    private final By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");

    private final By sectionBuns = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");

    private final By sectionSauces = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");

    private final By sectionFillings = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    private final By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");

    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public void clickEnterIntoAccountButton(){
        driver.findElement(enterIntoAccountButton).click();
    }

    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    public String getUrl() {
        return url;
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public By getConstructorButton(){
        return constructorButton;
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickOnBuns(){
        driver.findElement(sectionBuns).click();
    }

    public void clickOnSauces(){
        driver.findElement(sectionSauces).click();
    }

    public void clickOnFillings(){
        driver.findElement(sectionFillings).click();
    }



}
