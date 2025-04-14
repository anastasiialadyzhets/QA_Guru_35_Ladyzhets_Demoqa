import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Date;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {
    @BeforeAll
    static void BeforeAll(){
        Configuration.pageLoadStrategy= "eager";
    }
    @Test
    void successfulSearchTest() {
        open("https://demoqa.com/automation-practice-form/");
        $("#firstName").setValue("AnasTasiiA");
        $("#lastName").setValue("LadyZhets");
        $("[id=userEmail]").setValue("myteatemail@qwert.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__month").$(byText("13")).click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Social Studies").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();


        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        File myFile = new File(this.getClass().getResource("/HaroldPain.png").getFile());
        $("#uploadPicture").uploadFile(myFile);

        $("#currentAddress").setValue("stree Rasmus 123 building 10");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Lucknow").pressEnter();
        $("#submit").click();

        assert($("#example-modal-sizes-title-lg").getText().equals("Thanks for submitting the form"));


    }
}
