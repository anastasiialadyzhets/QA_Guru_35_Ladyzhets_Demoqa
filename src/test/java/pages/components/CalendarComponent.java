package pages.components;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {
    public void setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").$("option[value='" + year + "']").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day).click();
    }
}
