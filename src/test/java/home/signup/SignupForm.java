package home.signup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupForm {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signUpNavbar = By.xpath("//*[@id=\"signin2\"]");
    private By usernameBox = By.xpath("//*[@id=\"sign-username\"]");
    private By passwordBox = By.xpath("//*[@id=\"sign-password\"]");
    private By signupButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    public SignupForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openForm() {
        driver.findElement(signUpNavbar).click();
    }

    public void fillUserName(String userName) {
        driver.findElement(usernameBox).sendKeys(userName);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signupButton).click();
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
