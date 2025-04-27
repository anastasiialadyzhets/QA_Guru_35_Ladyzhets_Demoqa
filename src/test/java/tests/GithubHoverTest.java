package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class GithubHoverTest {
    @BeforeAll
    static void setupConfiguration(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://github.com";
        Configuration.browserSize="1920x1080";
    }
    @Test
    void successfulHoverTestFullMenu() {
        open("/");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $("[class='HeaderMenu-dropdown dropdown-menu rounded m-0 p-0 pt-2 pt-lg-4 " +
                "position-relative position-lg-absolute " +
                    "left-0 left-lg-n3 d-lg-flex flex-wrap dropdown-menu-wide']").$(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
