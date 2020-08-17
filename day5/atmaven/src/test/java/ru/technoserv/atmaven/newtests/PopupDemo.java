package ru.technoserv.atmaven.newtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class PopupDemo {
    public String baseUrl = "http://demo.guru99.com/popup.php";
    public WebDriver driver ;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    //public static void main(String[] args) throws InterruptedException {
    @Test
    public void elementExists() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Launching the site.
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window handle = " + mainWindow);

        // To handle all new opened window.
        Set<String> allWindows = driver.getWindowHandles();

        for (String childWindow : allWindows) {

            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                System.out.println("Child window handle = " + childWindow);
                // Switching to Child window
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();

                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath("/html/body/table/tbody/tr[1]/td/h2")));

                WebElement userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
                WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

                System.out.println(userIdElement.getText());
                System.out.println(passwordElement.getText());

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(mainWindow);
    }
    @AfterClass
    public void closeSite() {
        driver.quit();
    }
    }
