package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        removeAllAds();
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("New");
        $("#userEmail").setValue("alex@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("6505555555");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(Condition.text("1")).click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("images/img1.png");

        $("#currentAddress").setValue("1St Street");
        $("#state").click();
        $("#state").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Alex New"), text("alex@test.com"), text("6505555555"));
    }

    public static void removeAllAds() {
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('.popup-ad').remove();");
        executeJavaScript("$('#ad-container').remove();");
        executeJavaScript("$('.google-ads').remove();");
        executeJavaScript("$('.ad-banner').remove();");
    }
}
