package hw8.pages;

import static com.codeborne.selenide.Selenide.open;

public class DndSuPage {
    public DndSuPage openPage(String page){
        open(page);
        return this;
    }
}
