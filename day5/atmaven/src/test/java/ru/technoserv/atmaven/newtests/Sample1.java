package ru.technoserv.atmaven.newtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Sample1 {

    @Test
    public static void sam1Test() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        //WebDriver safariDriver = new SafariDriver();
        WebDriver chromeDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";

            //safariDriver.get(baseUrl);
            chromeDriver.get(baseUrl);

            //System.out.println("Safari title = " + safariDriver.getTitle());
            System.out.println("Chrome title = " + chromeDriver.getTitle());
        } finally {
            //safariDriver.quit();
            chromeDriver.quit();
        }
    }
}
