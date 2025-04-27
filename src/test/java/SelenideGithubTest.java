import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenideGithubTest {
    @BeforeAll
    static void setupConfiguration(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://github.com";
        Configuration.browserSize="1920x1080";
    }
    @Test
    void successfulTest() {
        open("/selenide/selenide");

        $("[aria-label=Repository]").$(byText("Wiki")).click();
        $("[class='Box-row wiki-more-pages-link']").$("button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).shouldBe(visible);
        String expectedCodeExample1= """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }""";

        String expectedCodeExample2= """
                class Tests {
                  @RegisterExtension\s
                  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();

                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }""";

        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).closest(".markdown-heading").sibling(0).shouldHave(text(expectedCodeExample1));
        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).closest(".markdown-heading").sibling(2).shouldHave(text(expectedCodeExample2));
    }
}
