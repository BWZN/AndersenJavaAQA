package lesson18;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTest {
    private static WebDriver driver;
    private static RegistrationPage registrationPage;

    @BeforeClass
    public void setup() {
        driver = DriverSetup.driverInit();
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public void stopDriver() {
        driver.quit();
    }

    @Test
    public void validValueRegistration() {
        registrationPage.openPage();
        registrationPage.setFirstName("Test");
        registrationPage.setLastName("Test2");
        registrationPage.setDateOfBirth("02/02/2002");
        registrationPage.setEmailAdress("Test6@domain.com");
        registrationPage.setPassword("123456789");
        registrationPage.setPasswordConfirmation("123456789");
        registrationPage.clickButton();
        registrationPage.checkLinkRedirection();
    }

    @Test
    public void linkRedirection() {
        registrationPage.openPage();
        registrationPage.checkSignInRedirection();
    }

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
