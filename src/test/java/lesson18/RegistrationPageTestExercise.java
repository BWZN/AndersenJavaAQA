package lesson18;

import io.qameta.allure.*;
import lesson15.utils.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listener.MyAllureListeners;

@Listeners({MyAllureListeners.class})
public class RegistrationPageTestExercise {
    private static WebDriver driver;
    private static RegistrationPageExercise registrationPage;

    @BeforeClass
    public void setup() {
        driver = DriverSetup.driverInit();
        registrationPage = new RegistrationPageExercise(driver);
    }

    @AfterClass
    public void stopDriver() {
        driver.quit();
    }

    @Description("Test with valid registration")
    @Severity(SeverityLevel.CRITICAL)
    @Story("US 1.1")
    @Test
    public void validValueRegistration() {
        registrationPage.openPage();
        registrationPage.setFirstName("Test");
        registrationPage.setLastName("Test2");
        registrationPage.setDateOfBirth("02/02/2002");
        registrationPage.setEmailAdress("Test23211114@domain.com");
        registrationPage.setPassword("123456789");
        registrationPage.setPasswordConfirmation("123456789");
        registrationPage.clickButton();
        registrationPage.checkLinkRedirection();
    }

    @Description("Test link redirection")
    @Severity(SeverityLevel.CRITICAL)
    @Story("US 1.2")
    @Test
    public void linkRedirection() {
        registrationPage.openPage();
        registrationPage.checkSignInRedirection();
    }

    @Description("Test required fields")
    @Severity(SeverityLevel.CRITICAL)
    @Story("US 1.2")
    @Test
    public void requiredFields() {
        registrationPage.openPage();
        registrationPage.setFirstName("");
        registrationPage.setLastName("");
        registrationPage.setDateOfBirth("");
        registrationPage.setEmailAdress("");
        registrationPage.setPassword("");
        registrationPage.setPasswordConfirmation("");
        registrationPage.clickButton();
        registrationPage.checkRequiredField();
    }

    @Description("Test registration with empty first name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("US 1.2")
    @Test
    public void registrationWithEmptyFirstName() {
        registrationPage.openPage();
        registrationPage.setFirstName("");
        registrationPage.setLastName("Test2");
        registrationPage.setDateOfBirth("02/02/2002");
        registrationPage.setEmailAdress("Test6@domain.com");
        registrationPage.setPassword("123456789");
        registrationPage.setPasswordConfirmation("123456789");
        registrationPage.clickButton();
        registrationPage.checkRequiredField();
    }

    @Description("Test with diff. passwords")
    @Severity(SeverityLevel.CRITICAL)
    @Story("US 1.2")
    @Test
    public void registrationWithDifferentPasswords() {
        registrationPage.openPage();
        registrationPage.setFirstName("Test");
        registrationPage.setLastName("Test2");
        registrationPage.setDateOfBirth("02/02/2002");
        registrationPage.setEmailAdress("Test6@domain.com");
        registrationPage.setPassword("123456789");
        registrationPage.setPasswordConfirmation("1234567891");
        registrationPage.clickButton();
        registrationPage.checkPasswordMatch();
    }

    @Description("Test with diff. languages")
    @Severity(SeverityLevel.CRITICAL)
    @Story("US 1.2")
    @Test
    public void registrationWithDifferentLanguage() {
        registrationPage.openPage();
        registrationPage.setFirstName("ЫАЫАЛЩЫЗ");
        registrationPage.setLastName("ЫАЫАЛЩЫЗ");
        registrationPage.setDateOfBirth("02/02/2002");
        registrationPage.setEmailAdress("ЫАЫАЛЩЫЗ@domain.com");
        registrationPage.setPassword("123456789");
        registrationPage.setPasswordConfirmation("123456789");
        registrationPage.clickButton();
    }
}
