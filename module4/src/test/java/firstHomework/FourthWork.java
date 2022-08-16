package firstHomework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FourthWork {

    @Test
    public void internetShopLocatorsTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");

        // act

        // assert
        $("footer").shouldBe(Condition.visible); // поиск по tag
        $("#menu").shouldBe(Condition.visible); // поиск по id
        $(".textwidget").shouldBe(Condition.visible); // поиск по class
        $("button[type=submit].searchsubmit").shouldBe(Condition.visible); // комбинированный поиск
        $("footer").$("#pages-2").$(Selectors.byText("Бонусная программа")).shouldBe(Condition.visible); // поиск по цепочке локаторов
    }

    @Test
    public void bookStoreLocatorsTest() {
        // arrange
        open("http://qajava.skillbox.ru/");

        // act

        // assert
        $("[test-info=about-us]").shouldBe(Condition.visible); // поиск по атрибуту test-info=about-us
        $(Selectors.byText("Бестселлеры"), 1).shouldBe(Condition.visible); // поиск по тексту
        $(Selectors.withText("Доставка")).shouldBe(Condition.visible); // поиск по частичному тексту
        $("a[href='checkout.html']").shouldBe(Condition.visible); // поиск по тексту и проверка по атрибуту

        $(Selectors.withText("Атлант")).parent().shouldBe(Condition.visible); // поиск родительского элемента
        $(Selectors.withText("Атлант")).closest(".book-info").shouldBe(Condition.visible); // поиск вверх по дереву
        $(".book-info").sibling(1).shouldHave(Condition.text("Ночь, когда огни погасли")); // поиск соседнего элемента
    }

    @Test
    public void xpathAndCssTest() {
        // arrange
        open("http://qajava.skillbox.ru/module04/lesson2/");

        // act

        // assert
        $x("//button[@id='write-to-me']").shouldBe(Condition.visible);
        $("#write-to-me").shouldBe(Condition.visible);
    }
}
