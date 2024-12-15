package home.signup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignupTest {
    private WebDriver driver;
    private SignupForm signUpForm;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        signUpForm = new SignupForm(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TC001_ValidSignup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        signUpForm.openForm();
        signUpForm.fillUserName("cizyy4");
        signUpForm.fillPassword("testing123");
        signUpForm.clickSignUpButton();
        String alertText = signUpForm.getAlertText();
        assertEquals("Sign up successful.", alertText, "Wrong alert message!");
        System.out.println("TC001 valid sign up successful.");
    }

    @Test
    public void TC002_InvalidSignup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUpForm.openForm();
        signUpForm.fillUserName("ciizy");
        signUpForm.fillPassword("testing123");
        signUpForm.clickSignUpButton();
        String alertText = signUpForm.getAlertText();
        assertEquals("This user already exist.", alertText, "Wrong alert message!");
        System.out.println("TC002 invalid sign up successful.");
    }
}
