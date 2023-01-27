package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.BaseURI.FEED;

public class FeedPage {

    WebDriver driver;

    private final String url = FEED;

    private final By feedHeader = By.xpath(".//h1[text()='Лента заказов']");

    public FeedPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getFeedHeader() {
        return feedHeader;
    }
}
