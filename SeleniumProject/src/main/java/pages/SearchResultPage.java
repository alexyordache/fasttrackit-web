package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    public WebDriver driver;

    private final By listOfProduct = By.cssSelector(".products-grid .item");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isProductInGrid(String productName) {
        List<WebElement> listOfProductsInGrid = driver.findElements(listOfProduct);
        for (WebElement element : listOfProductsInGrid) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addProductToCart(String productName) {
        List<WebElement> listOfProductsInGrid = driver.findElements(listOfProduct);
        for (WebElement element : listOfProductsInGrid) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                element.findElement(By.cssSelector(".btn-cart")).click();
                return true;
            }
        }
        return false;
    }
}
