package lesson18;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class RegistrationPageExercise {
    static final Logger logger = LoggerFactory.getLogger(RegistrationPageExercise.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPageExercise(WebDriver driver) {
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

    @Step("openPage")
    public void openPage() {
        driver.get("https://qa-course-01.andersenlab.com/registration");
    }

    @Step("setFirstName")
    public void setFirstName(String value) {
        logger.info("Setting first name");
        firstName.sendKeys(value);
    }

    @Step("setLastName")
    public void setLastName(String value) {
        lastName.sendKeys(value);
    }

    @Step("setDateOfBirth")
    public void setDateOfBirth(String value) {
        dateOfBirth.sendKeys(value);
    }

    @Step("setEmailAdress")
    public void setEmailAdress(String value) {
        logger.info("Setting email");
        emailAdress.sendKeys(value);
    }

    @Step("setPassword")
    public void setPassword(String value) {
        logger.info("Setting password");
        password.sendKeys(value);
    }

    @Step("setPasswordConfirmation")
    public void setPasswordConfirmation(String value) {
        passwordConfirmation.sendKeys(value);
    }

    @Step("clickButton")
    public void clickButton() {
        button.click();
    }

    @Step("getLink")
    public String getLink() {
        return driver.getCurrentUrl();
    }

    @Step("checkLinkRedirection")
    public void checkLinkRedirection() {
        logger.info("Checking link redirection");
        wait.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/login"));
    }

    @Step("checkSignInRedirection")
    public void checkSignInRedirection() {
        signInLink.click();
    }

    @Step("checkRequiredField")
    public void checkRequiredField() {
        wait.until(ExpectedConditions.visibilityOf(emptyField));
    }

    @Step("checkPasswordMatch")
    public void checkPasswordMatch() {
        wait.until(ExpectedConditions.visibilityOf(passwordMatch));
    }
}

