import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {
    @BeforeAll
    static void setupConfiguration(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
    }
    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("AnasTasiiA");
        $("#lastName").setValue("LadyZhets");
        $("#userEmail").setValue("myteatemail@qwert.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$("option[value='2000']").click();
        $(".react-datepicker__month-select").$("option[value='1']").click();
        $(".react-datepicker__day--013").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Social Studies").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("HaroldPain.png");

        $("#currentAddress").setValue("stree Rasmus 123 building 10");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("AnasTasiiA LadyZhets"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("myteatemail@qwert.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("13 February,2000"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("English, Social Studies, Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports, Reading"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("HaroldPain.png"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("stree Rasmus 123 building 10"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("Uttar Pradesh Lucknow"));
    }
}
