package lesson15;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Exercise3 {
    public static void main(String[] args) {
        WebDriver driver = DriverSetup.driverInit();
        driver.get("https://zoo.waw.pl/");

        WebElement welcome = driver.findElement(By.className("welcome"));
        int welcomeYPos = welcome.getLocation().y;
        int welcomeXPos = welcome.getLocation().x;
        int welcomeSize = welcome.getSize().height + welcome.getSize().width;

        WebElement som = driver.findElement(By.xpath("//a[contains(text(), \"SOM\")]"));
        int somYPos = som.getLocation().y;
        int somXPos = som.getLocation().x;
        int somSize = som.getSize().height + som.getSize().width;

        if (welcomeXPos < somXPos) {
            System.out.println("Welcome element X position: " + welcomeXPos + " its above SOM element X position: " + somXPos );
        } else {
            System.out.println("SOM X position: " + somXPos + " its above Welcome element X position: " + welcomeXPos );
        }

        if (welcomeYPos < somYPos) {
            System.out.println("Welcome Y position: " + welcomeYPos + " its more on left than SOM element Y position: " + somYPos);
        } else {
            System.out.println("SOM, Y position: " + somYPos + " its more on left than Welcome element Y position: " + welcomeYPos);
        }

        if (welcomeSize > somSize) {
            System.out.println("Welcome size: " + welcomeSize + " is bigger than SOM element size: " + somSize);
        } else {
            System.out.println("SOM size: " + somSize + " is bigger than Welcome element size: " + welcomeSize);
        }
    }
}
