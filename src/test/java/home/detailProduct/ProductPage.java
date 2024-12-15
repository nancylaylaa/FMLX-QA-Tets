package home.detailProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By productName = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a[contains(text(), 'Samsung galaxy')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public DetailProduct clickDetailProduct() {
        WebElement productSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        productSelect.click();
        return new DetailProduct(driver);
    }
}
