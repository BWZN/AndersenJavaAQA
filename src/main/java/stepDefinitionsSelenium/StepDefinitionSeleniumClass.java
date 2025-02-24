package stepDefinitionsSelenium;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson15.utils.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitionSeleniumClass {
    private WebDriver driver;
    private WebDriverWait wait;
    @After
    public void stopDriver() {
        driver.quit();
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

    @Given("Set up driver")
    public void set_up_driver() {
        driver = DriverSetup.driverInit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @When("I open Login page")
    public void i_open_login_page() {
        driver.get("https://qa-course-01.andersenlab.com/login");
    }
    @And("I set valid mail {}")
    public void i_set_valid_mail(String text) {
        emailAdress.sendKeys(text);
    }
    @And("I set valid password {}")
    public void i_set_valid_password(String text2) {
        password.sendKeys(text2);
    }
    @And("I click Submit button")
    public void i_click_submit_button() {
        button.click();
    }
    @Then("I redirect to profile page")
    public void i_redirect_to_profile_page() {
        wait.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/"));
    }

    @Then("I check error message")
    public void iCheckErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(invalidValues));
    }

    @Then("I check email requirement message")
    public void iCheckEmailRequirementMessage() {
        wait.until(ExpectedConditions.visibilityOf(invalidEmail));
    }
}
