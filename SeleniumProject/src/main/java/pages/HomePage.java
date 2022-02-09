package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    private final By myAccountLink = By.cssSelector(".skip-account .label");
    private final By loginLink = By.cssSelector("[title='Log In']");
    private final By searchField = By.id("search");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMyAccount() {
        driver.findElement(myAccountLink).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void executeSearch(String value) {
        driver.findElement(searchField).sendKeys(value + Keys.ENTER);
    }

    public void selectSubMenuItem() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector(".nav-primary .parent > a[href$='accessories.html']"));
        action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector(".nav-primary a[href$='jewelry.html']"))).click().build().perform();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
