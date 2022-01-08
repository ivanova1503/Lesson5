package dex.ivanova.lesson5.pages;

import com.codeborne.selenide.SelenideElement;
import dex.ivanova.lesson5.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {


    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
            emailInput= $("#userEmail"),
            gender= $("#genterWrapper"),
            addressInput=$("#currentAddress"),
            userNumber=$("#userNumber"),
            picture=$("#uploadPicture"),
            subject=$("#subjectsInput"),
            hobby=$("#hobbiesWrapper").$(byText("Sports")),
            state=$("#state"),
         city=$("#city"),
         stateWrapper =$("#stateCity-wrapper"),

        submit=$("#submit");

    // userGender=$("#genterWrapper").$(byText("Female"));


    public CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;

    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage currentAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    public RegistrationPage typeUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    /*public void setGender(String value) {
        userGender.setValue(value);
        userGender.click();

    }*/



    public RegistrationPage uploadPicture(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.setValue(value);
        subject.pressEnter();
        return this;
    }

    public void setHobby() {
        hobby.click();
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        city.click();
        stateWrapper.$(byText(value)).click();
        return this;
    }



    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public void clickSubmit() {
        submit.click();
    }





   /* public AnotherPage clickOnAnotherPage() {
        #("").click();
        return new AnotherPage;
    }
*/
    // проверка результатов таблицы
    public RegistrationPage checkResultsValue(String key, String value) {
       resultsTable.$(byText(key)).parent().shouldHave(text(value));
       return this;
   }


}
