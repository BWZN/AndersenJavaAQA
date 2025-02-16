package lesson17;

import lesson15.utils.DriverSetup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Exercise1 {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeMethod
    public void setup() {
        driver = DriverSetup.driverInit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://qa-course-01.andersenlab.com/");
        login();
    }

    @AfterMethod
    public void stopDriver() {
        driver.quit();
    }

    @Test
    public void selectTest(){
        navigator("//div[text()=\"Select\"]");

        Select countrySelect = new Select(driver.findElement(By.xpath("//select[@title=\"Select country\"]")));
        countrySelect.selectByVisibleText("USA");

        Select languageSelect = new Select(driver.findElement(By.xpath("//select[@title=\"Select language\"]")));
        languageSelect.selectByVisibleText("English");

        Select typeSelect = new Select(driver.findElement(By.xpath("//select[@title=\"Select type\"]")));
        typeSelect.selectByVisibleText("Testing");

        LocalDate today = LocalDate.now();
        LocalDate startDate = today.plusDays((8 - today.getDayOfWeek().getValue()) % 7);
        LocalDate lastDate = startDate.plusWeeks(2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);

        WebElement startDateInput = driver.findElement(By.xpath("//input[@data-calendar=1]"));
        startDateInput.clear();
        startDateInput.sendKeys(startDate.format(formatter));

        WebElement lastDateInput = driver.findElement(By.xpath("//input[@data-calendar=2]"));
        lastDateInput.clear();
        lastDateInput.sendKeys(lastDate.format(formatter));

        Select courseSelect = new Select(driver.findElement(By.id("MultipleSelect")));
        courseSelect.selectByVisibleText("AQA Java");
        courseSelect.selectByVisibleText("AQA Python");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class=\"mb-[35px] text-[24px] leading-[28.13px]\"]"))).getText(), "Unfortunately, we did not find any courses matching your chosen criteria.");
    }

    @Test
    public void dragAndDropTest() {
        navigator("//div[text()=\"Drag & Drop\"]");
        actions.dragAndDrop(driver.findElement(By.id("manual1")), driver.findElement(By.id("target-manual1"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("manual2")), driver.findElement(By.id("target-manual2"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("auto1")), driver.findElement(By.id("target-auto1"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("auto2")), driver.findElement(By.id("target-auto2"))).perform();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Congratulations! Let's test for the best!\"]"))).getText(), "Congratulations! Let's test for the best!");
    }

    @Test
    public void actionsAlertsIframesTest() {
        navigator("//div[text()=\"Actions, Alerts & Iframes\"]");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"w-full\"]"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.id("AlertButton")).click();
        checkAlert("You have called alert!", "Congratulations, you have successfully enrolled in the course!");
        actions.doubleClick(driver.findElement(By.xpath("//button[text()=\"Get Discount\"]"))).perform();
        checkAlert("Are you sure you want to apply the discount?", "You received a 10% discount on the second course.");
        actions.contextClick(driver.findElement(By.xpath("//button[@data-test-id=\"PromptButton\"]"))).perform();
        checkInputAlert("Here you may describe a reason why you are cancelling your registration (or leave this field empty).", "Test");
    }

    private void checkAlert(String expectedAlertText, String resultText) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, expectedAlertText);

        alert.accept();

        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"font-light flex\"]")));
        Assert.assertEquals(resultElement.getText(), resultText);
    }

    private void checkInputAlert(String expectedAlertText, String inputText) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, expectedAlertText);

        alert.sendKeys(inputText);
        alert.accept();

        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"font-light flex\"]")));
        Assert.assertTrue(resultElement.getText().contains(inputText));
    }

    private void login() {
        driver.findElement(By.name("email")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("test");
        driver.findElement(By.tagName("button")).click();
    }

    private void navigator(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"my-auto\"]")));

        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"my-auto\"]"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
    }
}
