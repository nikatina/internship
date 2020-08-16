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

        String dollarBuy = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/span")).getText();
        String dollarSale = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/span")).getText();

        float dBuy = Float.parseFloat(dollarBuy.replace(",","."));
        float dSale = Float.parseFloat(dollarSale.replace(",","."));

        Assert.assertFalse(dBuy  > dSale );
    }

    @Test
    public void euroBuyMoreThanSale() {

        String euroBuy = driver.findElement(By.cssSelector("tr:nth-child(3)>td:nth-child(2) span")).getText();
        String euroSale = driver.findElement(By.cssSelector("tr:nth-child(3)>td:nth-child(4) span")).getText();

        double eBuy = Double.parseDouble(euroBuy.replace(",","."));
        double eSale = Double.parseDouble(euroSale.replace(",","."));

        Assert.assertFalse(eBuy > eSale );
    }

    @AfterClass
    public void closeSite() {
        driver.close();
    }

}

