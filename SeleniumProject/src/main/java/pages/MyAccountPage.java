package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;

    private final By welcomeMessageParagraph = By.cssSelector(".hello strong");

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isUserLoggedIn(String userName){
        return driver.findElement(welcomeMessageParagraph).getText().equalsIgnoreCase("Hello, " + userName + "!");
    }
}
