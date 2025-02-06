package lesson16.parameters;


import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginCheckParam {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverSetup.driverInit();
    }

    @Test
    @Parameters({"email", "password"})
    public void invalidLoginTest(String email, String passwd) {
        driver.get("https://qa-course-01.andersenlab.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(passwd);
        driver.findElement(By.tagName("button")).click();

        Assert.assertEquals("Email or password is not valid",
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"absolute right-0 text-rose-500 text-sm\"]"))).getText());
    }

    @AfterMethod
    public void stopDriver() {
        driver.quit();
    }
}
