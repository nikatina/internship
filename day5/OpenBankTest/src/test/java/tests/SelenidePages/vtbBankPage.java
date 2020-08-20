package tests.SelenidePages;
import org.apache.commons.lang3.StringUtils;
import tests.WebDriverSettings;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class vtbBankPage extends WebDriverSettings {
    //private static String  url = "https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/";

    public void close_cck(){ $("#cookiemsgoffpls > p:nth-child(1)").click();  }

    public void course_from_menu(){ $x("/html/body/main/div/section[3]/div/div[2]/div[1]/div/div[3]/div/span/span[1]/span/span[2]/b").click();}

    public void course_to_menu(){ $x("/html/body/main/div/section[3]/div/div[2]/div[2]/div[1]/div[3]/div/span/span[1]/span/span[2]").click();}

    public void choose_rur_in_from(){
        course_from_menu();
        //myWaitVar.until(ExpectedConditions.elementToBeClickable($x("//input[@id=\"method1\"]/../..//li[contains(.,RUR)]"))).click();
        $x("//input[@id=\"method1\"]/../..//li[contains(.,\"RUR\")]").click();
    }

    public void choose_euro_in_from(){
        course_from_menu();
        $x("//input[@id=\"method1\"]/../..//li[contains(.,\"EUR\")]").click();
    }

    public void choose_dollar_in_from(){
        course_from_menu();
        $x("//input[@id=\"method1\"]/../..//li[contains(.,\"USD\")]").click();
    }

    public void choose_form_from_and_input_value( int value){
        $("#method1").setValue(String.valueOf(value));
    }

    public void choose_rur_in_to(){
        course_to_menu();
        $x("//input[@id=\"method2\"]/../..//li[contains(.,\"RUR\")]").click();
    }

    public void choose_euro_in_to(){
        course_to_menu();
        $x("//input[@id=\"method2\"]/../..//li[contains(.,\"EUR)\"]").click();
    }

    public void choose_dollar_in_to(){
        course_to_menu();
        $x("//input[@id=\"method2\"]/../..//li[contains(.,\"USD\")]").click();
    }

    public void choose_form_to_and_input_value( int value){
        $("#method2").setValue(String.valueOf(value));
    }
    public float choose_form_to_and_get_value(){
        String value = $("#method2").val();
        String value_1 = StringUtils.deleteWhitespace(value).replace(",",".").replaceAll("\\s+","").replaceAll("\u00a0", "");
        return Float.parseFloat(value_1);
    }

    public float get_dollar_course_byrur(){
        $x("//input[@id=\"method1\"]/../../../label").click();
        return Float.parseFloat($x("/html/body/main/div/section[3]/div/div[2]/div[2]/div[2]").getText().split(" ")[0].replace(",","."));
    }

    public float get_dollar_course_byusd(){
        $x("//input[@id=\"method1\"]/../../../label").click();
        return Float.parseFloat($x("/html/body/main/div/section[3]/div/div[2]/div[2]/div[2]").getText().split(" ")[4].replace(",","."));
    }

}
