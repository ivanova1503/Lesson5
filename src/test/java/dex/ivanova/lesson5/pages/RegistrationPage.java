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
            resultsTable = $(".table-responsive");

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
        firstNameInput.setValue(value);
        return this;
    }

   /* public AnotherPage clickOnAnotherPage() {
        #("").click();
        return new AnotherPage;
    }
*/

    public RegistrationPage checkResultsValue(String key, String value) {
       resultsTable.$(byText(key)).parent().shouldHave(text(value));
       return this;
   }


}
