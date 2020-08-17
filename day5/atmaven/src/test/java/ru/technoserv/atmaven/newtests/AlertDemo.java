package ru.technoserv.atmaven.newtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class AlertDemo {
    public String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
    public WebDriver driver ;


    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    //public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {

    @Test
    public void delCastTest() {
    // Alert Message handling
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage = alert.getText();

        // Displaying alert message
        System.out.println(alertMessage);
        // Accepting alert
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());

        // Switching to Alert
        Alert alert2 = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage2 = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage2, "Customer Successfully Delete!");
        System.out.println(alertMessage2);

        alert2.accept();
    }

    @AfterClass
    public void closeSite() { driver.quit(); }
    }