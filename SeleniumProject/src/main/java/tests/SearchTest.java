package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchResultPage;

public class SearchTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private SearchResultPage searchResultPage;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        searchResultPage = new SearchResultPage(driver);
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void searchTest() {
        homePage.executeSearch("Neck");
        Assert.assertTrue("Product not found!",
                searchResultPage.isProductInGrid("SILVER DESERT NECKLACE"));
    }

    @Test
    public void searchAndAddToCartTest() {
        homePage.executeSearch("Neck");
        Assert.assertTrue("Product was not added to cart!",
                searchResultPage.addProductToCart("SILVER DESERT NECKLACE"));
    }

    @Test
    public void navigateAndAddToCartTest() {
        homePage.selectSubMenuItem();
        Assert.assertTrue("Product was not added to cart!",
                searchResultPage.addProductToCart("SILVER DESERT NECKLACE"));
    }

    @After
    public void closeDriver() {
//        driver.close();
    }
}
