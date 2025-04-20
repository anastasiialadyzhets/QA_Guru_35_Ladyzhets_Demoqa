import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAnsDropTest {
    @BeforeAll
    static void setup(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://the-internet.herokuapp.com";
        Configuration.browserSize="1920x1080";
    }
    @Test
    void successDragAnsDropTest() {
        open("/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        actions().dragAndDrop($("#column-a"),$("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }
}
