package home.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private LoginForm loginForm;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        loginForm = new LoginForm(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TC003_ValidLogin() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginForm.openForm();
        loginForm.fillUsername("ciizy");
        loginForm.fillPassword("testing123");
        loginForm.clickLoginButton();
        String welcomeText = loginForm.getLoginMessage();
        assertEquals("Welcome ciizy", welcomeText, "Wrong message login");
        System.out.println("TC003 valid login successful.");
    }

    @Test
    public void TC004_InvalidLogin() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginForm.openForm();
        loginForm.fillUsername("icy");
        loginForm.fillPassword("testing123");
        loginForm.clickLoginButton();
        String alertText = loginForm.getAlertText();
        assertEquals("Wrong password.", alertText, "Wrong alert message!");
        System.out.println("TC004 invalid login successful.");
    }
}
