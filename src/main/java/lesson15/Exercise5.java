package lesson15;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Exercise5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetup.driverInit();
        driver.get("https://qa-course-01.andersenlab.com/login");

        driver.findElement(By.name("email")).sendKeys("youremail");
        driver.findElement(By.name("password")).sendKeys("yourpassword");
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        WebElement uploadFile = driver.findElement(By.xpath("//input[@type=\"file\"]"));
        uploadFile.sendKeys("pathtofile");
    }
}
