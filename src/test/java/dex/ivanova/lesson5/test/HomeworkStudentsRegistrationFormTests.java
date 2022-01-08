package dex.ivanova.lesson5.test;

import com.codeborne.selenide.Configuration;
import dex.ivanova.lesson5.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkStudentsRegistrationFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    public static class StudentsRegistrationFormWithPageObjectsTests {

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
            registrationPage.typeEmail("test@test.com");
            registrationPage.setGender("Female");
            registrationPage.currentAddress("Tiraspol");
            registrationPage.calendarComponent.setDate("30", "July", "2008");
            registrationPage.typeUserNumber("7777703333");
            registrationPage.uploadPicture("img/1.png");
            registrationPage.setSubject("Math");
            registrationPage.setHobby();
            registrationPage.setState("NCR");
            registrationPage.setCity("Delhi");
            registrationPage.clickSubmit();

            // проверки
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            registrationPage.checkResultsValue("Student Name", "Yuliya Ivanova")
                    .checkResultsValue("Student Email", "test@test.com")
                    .checkResultsValue("Gender", "Female")
                    .checkResultsValue("Mobile", "7777703333")
                    .checkResultsValue("Date of Birth", "30 July,2008")
                    .checkResultsValue("Subjects", "Maths")
                    .checkResultsValue("Hobbies", "Sports")
                    .checkResultsValue("Picture", "1.png")
                    .checkResultsValue("Address", "Tiraspol")
                    .checkResultsValue("State and City", "NCR Delhi");

        }

    }
}