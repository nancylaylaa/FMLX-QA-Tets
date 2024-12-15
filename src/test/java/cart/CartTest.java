package cart;

import home.detailProduct.DetailProduct;
import home.detailProduct.ProductPage;
import home.login.LoginForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    private WebDriver driver;
    private LoginForm loginForm;
    private DetailProduct detailProduct;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginForm = new LoginForm(driver);
        loginForm.openForm();
        loginForm.fillUsername("ciizy");
        loginForm.fillPassword("testing123");
        loginForm.clickLoginButton();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TC005_DetailProduct() throws Exception {
        productPage = new ProductPage(driver);
        Thread.sleep(1000);
        productPage.clickDetailProduct();
        detailProduct = new DetailProduct(driver);
        detailProduct.addProductToCart();
        String messageAlert = detailProduct.getAlertText();
        assertEquals("Product added.", messageAlert, "Wrong message login");
    }

    @Test
    public void TC006_PlaceOrder() throws Exception {
        cartPage = new CartPage(driver);
        Thread.sleep(1000);
        cartPage.openCart();
        cartPage.openFormPlaceOrder();
        cartPage.fillNameForm("nancy");
        cartPage.fillCountryForm("indonesia");
        cartPage.fillCityForm("salatiga");
        cartPage.fillCreditCardForm("bsi");
        cartPage.fillMonthBillForm("december");
        cartPage.fillYearBillForm("2024");
        String messagePurchase = cartPage.clickPurchase();
        assertEquals("Thank you for your purchase!", messagePurchase, "Wrong message purchase");
        System.out.println("TC006 place order successfull");
    }
}
