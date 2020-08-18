package tests;
import tests.SelenidePages.openBankPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class OpenbankCourseCheck_selenide {
        @Test
        public void testDollarBuyMoreThanSale() {
                openBankPage obp = open("https://www.open.ru", openBankPage.class);
                Assert.assertFalse(obp.getDollarBuy() > obp.getDollarSale());
        }

        @Test
        public void testEuroBuyMoreThanSale() {
                openBankPage obp = open("https://www.open.ru", openBankPage.class);
                Assert.assertFalse(obp.getEuroBuy() > obp.getEuroSale());

        }
}

