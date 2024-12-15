package home.detailProduct;

import cart.CartPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailProduct {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");

    public DetailProduct(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

//    public String getUrl(){
//        return driver.getCurrentUrl();
//    }

    public CartPage addProductToCart() {
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        addToCart.click();
        return new CartPage(driver);
    }

    public String getAlertText() {
        if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } else {
            return "No alert appeared.";
        }
    }
}
