package lesson15;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Exercise1_3 {
    public static void main(String[] args) {
        WebDriver driver = DriverSetup.driverInit();
        driver.get("https://qa-course-01.andersenlab.com/login");

        //LogIn Test Case - LOG03
        driver.findElement(By.name("email")).sendKeys("e2xample@domain.com");
        driver.findElement(By.name("password")).sendKeys("12");
        driver.findElement(By.tagName("button")).click();
    }
}
