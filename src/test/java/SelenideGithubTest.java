import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {
    @BeforeAll
    static void BeforeAll(){
        Configuration.pageLoadStrategy= "eager";
    }
    @Test
    void successfulTest() {
        open("https://github.com/selenide/selenide");

        $("[aria-label=Repository]").$(byText("Wiki")).click();
        $("[class='Box-row wiki-more-pages-link']").$("button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();


        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).shouldBe(visible);
    }
}
