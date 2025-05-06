package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SubmitRegistrationTableComponent {
    public SubmitRegistrationTableComponent checkTableResult(String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(exactText(value));
        return this;
    }
    public SubmitRegistrationTableComponent checkHeader(String value){
        if (!value.isEmpty()) {
            $("#example-modal-sizes-title-lg").shouldHave(text(value));
        }else  $("#example-modal-sizes-title-lg").shouldNotBe(visible);
        return this;
    }
}
