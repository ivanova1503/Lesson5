package dex.ivanova.lesson5;


import com.codeborne.selenide.Configuration;
import dex.ivanova.lesson5.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentsRegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Yuliya");
        registrationPage.typeLastName("Ivanova");

        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777703333");

        registrationPage.calendarComponent.setDate("30", "July", "2008");


        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Tiraspol");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResultsValue("Student name", "Yuliya Ivanova")
                .checkResultsValue("Student name", "Yuliya Ivanova")
                .checkResultsValue("Student name", "Yuliya Ivanova")
                .checkResultsValue("Student name", "Yuliya Ivanova");

    }




    @Test
    void fillFormWithDSLTest() {
        registrationPage.openPage()
                        .typeFirstName("Yuliya")
                        .typeLastName("Ivanova");

        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777703333");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label$='July 30th, 2008']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Tiraspol");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationPage.checkResultsValue("Student name", "Yuliya Ivanova");




        }
}