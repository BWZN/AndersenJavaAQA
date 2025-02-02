package lesson15;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class Exercise2 {
    public static void main(String[] args) {
        WebDriver driver = DriverSetup.driverInit();

        String[] urls = {
                "http://www.automationpractice.pl/index.php",
                "https://zoo.waw.pl/",
                "https://www.w3schools.com/",
                "https://www.clickspeedtester.com/click-counter/",
                "https://andersenlab.com/"
        };

        driver.get(urls[0]);
        System.out.println("Page Name - " + driver.getTitle());
        System.out.println("Page URL - " + driver.getCurrentUrl());

        for (int i = 1; i < urls.length; i++) {
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(urls[i]);

            System.out.println("Page Name - " + driver.getTitle());
            System.out.println("Page URL - " + driver.getCurrentUrl());
        }

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Zoo")) {
                driver.close();
            }
        }
    }
}
