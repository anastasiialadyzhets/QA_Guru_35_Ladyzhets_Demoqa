package hw8.pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DndSuComponent {
    public DndSuComponent checkSearchToolbarVisible() {
        $("[class='search search_columns']").shouldBe(visible);
        return this;
    }
    public DndSuComponent checkSpellListItemForGroupById(String letter, String spellName,int i) {
        $(byText(letter)).sibling(0).$$("[class='cards_list__item']").get(i).shouldHave(text(spellName));
        return this;
    }
    public DndSuComponent checkClassNameTranstationCorrect(String nameRu, String nameEn) {
        $("[class='articles-tiles']").$(byText(nameRu)).sibling(0).shouldHave(text(nameEn));
        return this;
    }
}
