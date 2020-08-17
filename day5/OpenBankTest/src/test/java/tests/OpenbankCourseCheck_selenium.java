package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenbankCourseCheck_selenium {
    public String baseUrl = "https://www.open.ru/";
    public WebDriver driver ;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void dollarBuyMoreThanSale() {

        double dollarBuy = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/span")).getText().replace(",","."));
        double dollarSale = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/span")).getText().replace(",","."));

        Assert.assertFalse(dollarBuy  > dollarSale );
    }

    @Test
    public void euroBuyMoreThanSale() {

        double euroBuy = Double.parseDouble(driver.findElement(By.cssSelector("tr:nth-child(3)>td:nth-child(2) span")).getText().replace(",","."));
        double euroSale = Double.parseDouble(driver.findElement(By.cssSelector("tr:nth-child(3)>td:nth-child(4) span")).getText().replace(",","."));

        Assert.assertFalse(euroBuy > euroSale );
    }

    @AfterClass
    public void closeSite() {
        driver.close();
    }

}

