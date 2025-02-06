package lesson16.dataProvider;

import org.testng.Assert;
import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginCheck {
    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String email, String passwd){
        WebDriver driver = DriverSetup.driverInit();
        driver.get("https://qa-course-01.andersenlab.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(String.valueOf(passwd));
        driver.findElement(By.tagName("button")).click();

        Assert.assertEquals("Email or password is not valid",
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"absolute right-0 text-rose-500 text-sm\"]"))).getText());
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] createData(){
        return new Object[][]{
                {"email1@email.email", "21424134314"},{"email2@email.email", "23345197"},{"email3@email.email", "23537197"},
        };
    }
}
