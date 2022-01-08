package dex.ivanova.lesson5.test;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkStudentsRegistrationFormWithFakerTests {

    Faker faker = new Faker();

    String firstName= faker.name().firstName();
    String lastName= faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String mobile = faker.number().digits(10);

    SelenideElement
            tableResponse=$(".table-responsive");
    
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label$='July 30th, 2008']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

       
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        tableResponse.$(byText("Student Name")).parent().shouldHave(text(firstName + " " +lastName));
        tableResponse.$(byText("Student Email")).parent().shouldHave(text(userEmail));
        tableResponse.$(byText("Mobile")).parent().shouldHave(text(mobile));
        tableResponse.$(byText("Address")).parent().shouldHave(text(currentAddress));
        

    }
}