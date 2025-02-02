package lesson15;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Exercise1_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetup.driverInit();
        driver.get("https://qa-course-01.andersenlab.com/registration");

        Thread.sleep(4000);
        //Registration Test Case 2 - REG08
        driver.findElement(By.xpath("//a[@data-registration-link='RegistrationPageLink']")).click();
    }
}
