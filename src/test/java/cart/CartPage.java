package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By cartNavbar = By.xpath("//*[@id=\"cartur\"]");
    private By productName = By.xpath("//td[contains(text(), 'Samsung galaxy')]");
    private By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private By buyerName = By.xpath("//*[@id=\"name\"]");
    private By buyerCountry = By.xpath("//*[@id=\"country\"]");
    private By buyerCity = By.xpath("//*[@id=\"city\"]");
    private By buyerCreditCard = By.xpath("//*[@id=\"card\"]");
    private By monthBill = By.xpath("//*[@id=\"month\"]");
    private By yearBill = By.xpath("//*[@id=\"year\"]");
    private By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private By messagePurchase = By.xpath("//h2[contains(text(), 'Thank you for your purchase')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void openCart() {
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(cartNavbar));
        actions.click(cart).build().perform();
    }

//    public String verifyProductName() {
//        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
//        product.click();
//        return product.getText();
//    }

    public void openFormPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public void fillNameForm(String name) {
        driver.findElement(buyerName).sendKeys(name);
    }

    public void fillCountryForm(String country) {
        driver.findElement(buyerCountry).sendKeys(country);
    }

    public void fillCityForm(String city) {
        driver.findElement(buyerCity).sendKeys(city);
    }

    public void fillCreditCardForm(String creditCard) {
        driver.findElement(buyerCreditCard).sendKeys(creditCard);
    }

    public void fillMonthBillForm(String month) {
        driver.findElement(monthBill).sendKeys(month);
    }

    public void fillYearBillForm(String year) {
        driver.findElement(yearBill).sendKeys(year);
    }

    public String clickPurchase() {
        driver.findElement(purchaseButton).click();
        WebElement purchaseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(messagePurchase));
        purchaseMessage.click();
        return purchaseMessage.getText();
    }
}
