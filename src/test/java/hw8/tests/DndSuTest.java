package hw8.tests;

import org.junit.jupiter.params.provider.*;
import com.codeborne.selenide.Configuration;
import hw8.data.AlpabetRu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import hw8.pages.DndSuPage;
import hw8.pages.components.DndSuComponent;

import java.util.List;
import java.util.stream.Stream;


public class DndSuTest {
    @BeforeAll
    static void setupConfiguration(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://dnd.su";
        Configuration.browserSize="1920x1080";
    }
    @ValueSource(strings = {
            "/spells", "/items", "/bestiary","/race","/class"
    })
    @ParameterizedTest(name = "Страница {0} содержит меню навигации и поиска")
    void pageHeadersTest(String pageName) {
        DndSuPage dndSuPage= new DndSuPage();
        dndSuPage.openPage(pageName+"/");

        DndSuComponent dndSuComponent = new DndSuComponent();
        dndSuComponent.checkSearchToolbarVisible();
    }
    @EnumSource(AlpabetRu.class)
    static Stream<Arguments> spellsGroupedByAlphabetData() {
        return Stream.of(
                Arguments.of(
                        AlpabetRu.L1,
                        List.of("Адское возмездие", "Антипатия/симпатия", "Аура живучести", "Аура жизни", "Аура очищения", "Аура святости", "Ашардалонова поступь")
                ),
                Arguments.of(
                        AlpabetRu.L2,
                        List.of("Безмолвный образ", "Бесследное передвижение", "Благословение", "Благословение удачи", "Божественное благоволение", "Божественное оружие", "Божественное слово"
                                ,"Болезненное сияние","Брешь в реальности","Брызги кислоты","Быстрые друзья","Быстрый гонец Гальдера","Быстрый колчан")
                )
        );
    }
    @MethodSource("spellsGroupedByAlphabetData")
    @ParameterizedTest(name = "Блок {0} содержит заданный список заклинаний в алфавитном порядке")
    void spellsGroupedByAlphabetTest(AlpabetRu alpabetLetter, List<String> spellList) {
        DndSuPage dndSuPage= new DndSuPage();
        dndSuPage.openPage("/spells");

        DndSuComponent dndSuComponent = new DndSuComponent();

        int i=spellList.size()-1;
        while (i>= 0) {
            dndSuComponent.checkSpellListItemForGroupById(alpabetLetter.value,spellList.get(i),i);
            i--;
        }
    }
    @CsvSource(value = {
            "Бард , Bard",
            "Варвар , Barbarian",
            "Воин , Fighter",
            "Волшебник , Wizard",
            "Друид , Druid",
            "Жрец , Cleric",
            "Изобретатель , Artificer",
            "Колдун , Warlock",
            "Монах , Monk",
            "Паладин , Paladin",
            "Плут , Rogue",
            "Следопыт , Ranger",
            "Чародей , Sorcerer",
    })
    @ParameterizedTest(name = "Для русскоязычного наименования класса {0} отображается оригинал на англ: {1}")
    void classListCheckEnNameTest(String nameRu, String nameEn) {
        DndSuPage dndSuPage= new DndSuPage();
        dndSuPage.openPage("/class");

        DndSuComponent dndSuComponent = new DndSuComponent();
        dndSuComponent.checkClassNameTranstationCorrect(nameRu,nameEn);
    }
}
