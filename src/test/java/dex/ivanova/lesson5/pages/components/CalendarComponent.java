package dex.ivanova.lesson5.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {


    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        //1 вариант
       // $(".react-datepicker__day--0"+ day + ":not(.react-datepicker__day--outside-month)").click();

        //вариант2
       String dayLocator = format(".react-datepcker__day--0%s:not(.react-datepicker__day--outside-month)",day);
       $(dayLocator).click();



    }
}