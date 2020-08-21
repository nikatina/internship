package tests;
import tests.SelenidePages.openBankPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class OpenbankCourseCheck_selenide {
        @Test
        public void testDollarBuyMoreThanSale() throws InterruptedException {
                Thread.sleep(500);
                openBankPage obp = open("https://www.open.ru", openBankPage.class);
                Assert.assertFalse(obp.getDollarBuy() > obp.getDollarSale());
        }

        @Test
        public void testEuroBuyMoreThanSale() throws InterruptedException {
                Thread.sleep(500);
                openBankPage obp = open("https://www.open.ru", openBankPage.class);
                Assert.assertFalse(obp.getEuroBuy() > obp.getEuroSale());

        }
}

