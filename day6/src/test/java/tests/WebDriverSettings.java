package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class WebDriverSettings {
    public ChromeDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        //driver.executeScript("document.body.style.zoom='60%'");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
