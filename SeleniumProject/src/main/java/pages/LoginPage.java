package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private final By emailField = By.id("email");
    private final By passField = By.id("pass");
    private final By loginButton = By.id("send2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassField(String password) {
        driver.findElement(passField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
