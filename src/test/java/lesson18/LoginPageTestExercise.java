package lesson18;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTestExercise {
    private static WebDriver driver;
    private static LoginPageExercise loginPage;

    @BeforeClass
    public void setup() {
        driver = DriverSetup.driverInit();
        loginPage = new LoginPageExercise(driver);
    }

    @AfterClass
    public void stopDriver() {
        driver.quit();
    }

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.setEmailAdress("test");
        loginPage.setPassword("test");
        loginPage.clickButton();
        loginPage.checkLinkRedirection();
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();
        loginPage.setEmailAdress("sfqwfefqfeqf@gmail.com");
        loginPage.setPassword("hihihihih");
        loginPage.clickButton();
        loginPage.invalidValueCheck();
    }

    @Test
    public void emptyEmail() {
        loginPage.openPage();
        loginPage.setEmailAdress("");
        loginPage.setPassword("gegefeqfqe");
        loginPage.requireEmail();
    }

    @Test
    public void linkRedirection() {
        loginPage.openPage();
        loginPage.registrationRedirection();
    }
}
