package home.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginForm {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginNavbar = By.xpath("//*[@id=\"login2\"]");
    private By usernameBox = By.xpath("//*[@id=\"loginusername\"]");
    private By passwordBox = By.xpath("//*[@id=\"loginpassword\"]");
    private By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private By welcomeText = By.xpath("//*[@id=\"nameofuser\"]");

    public LoginForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openForm() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginNavbar));
        loginButton.click();
    }

    public void fillUsername(String username) {
        driver.findElement(usernameBox).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getLoginMessage() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        titleElement.click();
        return titleElement.getText();
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
