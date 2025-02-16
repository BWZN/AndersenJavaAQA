package lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    private static WebElement firstName;

    @FindBy(name = "lastName")
    private static WebElement lastName;

    @FindBy(name = "dateOfBirth")
    private static WebElement dateOfBirth;

    @FindBy(name = "email")
    private static WebElement emailAdress;

    @FindBy(name = "password")
    private static WebElement password;

    @FindBy(name = "passwordConfirmation")
    private static WebElement passwordConfirmation;

    @FindBy(tagName = "button")
    private static WebElement button;

    @FindBy(xpath = "//a[@data-registration-link='RegistrationPageLink']")
    private static WebElement signInLink;

    @FindBy(xpath = "(//span[text()=\"Required\"])[1]")
    private static WebElement emptyField;

    @FindBy(xpath = "(//span[text()=\"Passwords must match\"])[1]")
    private static WebElement passwordMatch;

    public void openPage() {
        driver.get("https://qa-course-01.andersenlab.com/registration");
    }

    public void setFirstName(String value) {
        firstName.sendKeys(value);
    }

    public void setLastName(String value) {
        lastName.sendKeys(value);
    }

    public void setDateOfBirth(String value) {
        dateOfBirth.sendKeys(value);
    }

    public void setEmailAdress(String value) {
        emailAdress.sendKeys(value);
    }

    public void setPassword(String value) {
        password.sendKeys(value);
    }

    public void setPasswordConfirmation(String value) {
        passwordConfirmation.sendKeys(value);
    }

    public void clickButton() {
        button.click();
    }

    public String getLink() {
        return driver.getCurrentUrl();
    }

    public void checkLinkRedirection() {
        wait.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/login"));
    }

    public void checkSignInRedirection() {
        signInLink.click();
    }

    public void checkRequiredField() {
        wait.until(ExpectedConditions.visibilityOf(emptyField));
    }

    public void checkPasswordMatch() {
        wait.until(ExpectedConditions.visibilityOf(passwordMatch));
    }
}

