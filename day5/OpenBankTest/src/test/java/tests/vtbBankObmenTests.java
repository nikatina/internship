package tests;
import org.testng.Assert;
import tests.SelenidePages.vtbBankPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;


public class vtbBankObmenTests {
    @Test
    public void test200RurToDollar() {
        vtbBankPage vtbpage = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", vtbBankPage.class);
        //vtbpage.close_cck();
        int rubles_count = 200;
        vtbpage.choose_form_from_and_input_value(rubles_count);
        vtbpage.choose_rur_in_from();
        vtbpage.choose_dollar_in_to();
        float count_dollars = vtbpage.choose_form_to_and_get_value();
        float count_dollars_new = rubles_count / vtbpage.get_dollar_course_byrur();
        Assert.assertNotEquals(count_dollars, count_dollars_new);
    }

    @Test
    public void test3MRurToDollar() {
        vtbBankPage vtbpage = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", vtbBankPage.class);
        //vtbpage.close_cck();
        int rubles_count = 3000000;
        vtbpage.choose_form_from_and_input_value(rubles_count);
        vtbpage.choose_rur_in_from();
        vtbpage.choose_dollar_in_to();
        float count_dollars = vtbpage.choose_form_to_and_get_value();
        float count_dollars_new = rubles_count / vtbpage.get_dollar_course_byrur();
        Assert.assertNotEquals(count_dollars, count_dollars_new);
    }

    @Test
    public void test200DolToRur() {
        vtbBankPage vtbpage = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", vtbBankPage.class);
        vtbpage.close_cck();
        int dollars_count = 200;
        vtbpage.choose_dollar_in_from();
        vtbpage.choose_form_from_and_input_value(dollars_count);
        vtbpage.choose_rur_in_to();
        Assert.assertNotEquals(vtbpage.choose_form_to_and_get_value(), dollars_count * vtbpage.get_dollar_course_byusd());
    }

    @Test
    public void test40kDolToRur() {
        vtbBankPage vtbpage = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", vtbBankPage.class);
        //vtbpage.close_cck();
        int dollars_count = 40000;
        vtbpage.choose_dollar_in_from();
        vtbpage.choose_form_from_and_input_value(dollars_count);
        vtbpage.choose_rur_in_to();
        Assert.assertNotEquals(vtbpage.choose_form_to_and_get_value(), dollars_count * vtbpage.get_dollar_course_byusd());
    }
}
