package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SubmitRegistrationFormDemoQA {
    public SubmitRegistrationFormDemoQA checkName(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("Student Name")).sibling(0).shouldBe(empty);
        return this;
    }
    public SubmitRegistrationFormDemoQA checkEmail(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("Student Email")).sibling(0).shouldBe(empty);

        return this;
    }
    public SubmitRegistrationFormDemoQA checkGender(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("Gender")).sibling(0).shouldBe(empty);

        return this;
    }
    public SubmitRegistrationFormDemoQA checkPhone(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("Mobile")).sibling(0).shouldBe(empty);

        return this;
    }
    public SubmitRegistrationFormDemoQA checkDate(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldBe(empty);

        return this;
    }
    public SubmitRegistrationFormDemoQA checkSubjects(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("Subjects")).sibling(0).shouldBe(empty);
        return this;
    }
    public SubmitRegistrationFormDemoQA checkHobbies(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldBe(empty);
        return this;
    }
    public SubmitRegistrationFormDemoQA checkUploadedFile(String fileName){
        if (!fileName.isEmpty()) {
            $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(fileName));
        }else $(".table-responsive").$(byText("Picture")).sibling(0).shouldBe(empty);
        return this;
    }
    public SubmitRegistrationFormDemoQA checkAddress(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(value));
        } else $(".table-responsive").$(byText("Address")).sibling(0).shouldBe(empty);

        return this;
    }
    public SubmitRegistrationFormDemoQA checkLocation(String value){
        if (!value.isEmpty()) {
            $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(value));
        }else $(".table-responsive").$(byText("State and City")).sibling(0).shouldBe(empty);

        return this;
    }
    public SubmitRegistrationFormDemoQA checkHeader(String value){
        if (!value.isEmpty()) {
            $("#example-modal-sizes-title-lg").shouldHave(text(value));
        }else  $("#example-modal-sizes-title-lg").shouldNotBe(visible);

        return this;
    }
}
