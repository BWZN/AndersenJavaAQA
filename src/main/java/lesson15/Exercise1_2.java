package lesson15;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Exercise1_2 {
    public static void main(String[] args) {
        WebDriver driver = DriverSetup.driverInit();
        driver.get("https://qa-course-01.andersenlab.com/login");

        //LogIn Test Case - LOG01
        //This Test Case is also Exercise 4
        driver.findElement(By.name("email")).sendKeys("example@domain.com");
        driver.findElement(By.name("password")).sendKeys("!S12345678");
        driver.findElement(By.tagName("button")).click();
    }
}
