package lesson18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    private static WebElement emailAdress;

    @FindBy(name = "password")
    private static WebElement password;

    @FindBy(tagName = "button")
    private static WebElement button;

    @FindBy(xpath = "//span[text()='Required']")
    private static WebElement invalidEmail;

    @FindBy(xpath = "//span[text()=\"Email or password is not valid\"]")
    private static WebElement invalidValues;

    @FindBy(xpath = "//span[text()=\"Registration\"]")
    private static WebElement registrationLink;

    public void openPage() {
        driver.get("https://qa-course-01.andersenlab.com/login");
    }

    public void setEmailAdress(String value) {
        emailAdress.sendKeys(value);
    }

    public void setPassword(String value) {
        password.sendKeys(value);
    }

    public void clickButton() {
        button.click();
    }

    public String getLink() {
        return driver.getCurrentUrl();
    }

    public void checkLinkRedirection() {
        wait.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/"));
    }

    public void requireEmail() {
        wait.until(ExpectedConditions.visibilityOf(invalidEmail));
    }

    public void invalidValueCheck() {
        wait.until(ExpectedConditions.visibilityOf(invalidValues));
    }

    public void registrationRedirection() {
        registrationLink.click();
    }
}
