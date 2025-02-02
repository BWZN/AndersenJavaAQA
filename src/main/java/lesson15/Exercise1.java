package lesson15;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Exercise1 {
    public static void main(String[] args) {
        // Link to table from HW14 - https://docs.google.com/spreadsheets/d/12JAmvKT63XvZsA2NIXnie8xv2UaDyaxeocsTnJzEnww/edit?gid=0#gid=0
        WebDriver driver = DriverSetup.driverInit();
        driver.get("https://qa-course-01.andersenlab.com/registration");

        //Registration Test Case 1 - REG01
        driver.findElement(By.name("firstName")).sendKeys("Boby");
        driver.findElement(By.name("lastName")).sendKeys("Bob");
        driver.findElement(By.name("dateOfBirth")).sendKeys("02/02/2002");
        driver.findElement(By.name("email")).sendKeys("example@domain.com");
        driver.findElement(By.name("password")).sendKeys("!S12345678");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("!S12345678");
        driver.findElement(By.tagName("button")).click();
    }
}
