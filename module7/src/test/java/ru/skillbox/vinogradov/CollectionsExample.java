package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CollectionsExample {

    @Test
    void simpleCollectionsExample(){
        open("http://intershop2.skillbox.ru/");

        ElementsCollection headers=$$("h2");// размер коллекции больше или равен 0

        SelenideElement firstHeader=$("h2");
    }

    @Test
    void collectionSelectors(){
        open("http://intershop2.skillbox.ru/");

        $$("h2");
        $$(".menu-item");

        $$(byText("Книги"));
        $$(withText("Мой"));

        $$x("//h2");
        $$(byXpath("//h2"));

        $$("abrakadbra");

    }

    @Test
    void collectionFilterOperations(){
        open("http://intershop2.skillbox.ru/");

        $$("h2").filterBy(visible);
        $$("h2").filterBy(text("Распродажа"));

        $$("div").filterBy(attribute("id"));
        $$("div").filterBy(cssClass("header-right"));

        $$("h2").excludeWith(hidden);
        $$("h2").excludeWith(text("Распродажа"));

        $$("div").first(5);
        $$("div").last(3);
    }

    @Test
    void singleElementOperations(){
        open("http://intershop2.skillbox.ru/");

        $$("h2").first();
        $$("h2").last();

        $$("h2").get(0); // first
        $$("h2").get(1); // второй элемент

        $$("h2").findBy(visible);
        SelenideElement headerSales=$$("h2").findBy(text("Распродажа"));

        headerSales.click();
        $$("h2").first().click();
        $$("h2").first().shouldHave(text("Интернет магазин"));

        $$("h2").first();
        $("h2");

        $$("h2").get(1);
        $("h2",1);

        SelenideElement firstMenu = $$("h2").first();
        SelenideElement menu = $("h2");

        $$("div").filterBy(visible).excludeWith(text("магазин")).first(5).filterBy(text("Купить"))
                .findBy(attribute("id"));

    }

    @Test
    void iterationOverCollection(){
        open("http://intershop2.skillbox.ru/");

        // Предупреждение! Этот код опасный и может быть очень нестабильным
        ElementsCollection links=$$("a");
        for (SelenideElement link:links){
            link.click();
        }

        links.get(0).click();
        // проверка
        links.get(1).click();
    }

    @Test
    void sizeAssertionsForCollections(){
        open("http://intershop2.skillbox.ru/");

        $$("h2").filterBy(hidden).shouldHave(size(0));
        $$("h2").filterBy(hidden).shouldBe(CollectionCondition.empty);

        $$("abrakadabra").shouldHave(size(0));

        $$("h2").shouldHave(size(3));

        $$("h2").shouldHave(sizeGreaterThan(2));
        $$("h2").shouldHave(sizeGreaterThanOrEqual(3));

        $$("h2").shouldHave(sizeLessThan(4));
        $$("h2").shouldHave(sizeLessThanOrEqual(3));

        $$("h2").shouldHave(sizeNotEqual(2));
    }

    @Test
    void contentAssertionsForCollections(){
        open("http://intershop2.skillbox.ru/");

        $$("h2").shouldHave(texts("Интернет","распродажа","НОВЫЕ ПОСТУПЛЕНИЯ"));
        $$("h2").shouldHave(exactTexts("Интернет магазин", "распродажа", "НОВЫЕ ПОСТУПЛЕНИЯ"));

        $$("h2").shouldHave(containExactTextsCaseSensitive("Интернет магазин","НОВЫЕ ПОСТУПЛЕНИЯ","РАСПРОДАЖА"));
        $$("h2").shouldHave(containExactTextsCaseSensitive("НОВЫЕ ПОСТУПЛЕНИЯ","РАСПРОДАЖА"));

        $$("h2").shouldHave(textsInAnyOrder("Интернет","НОВЫЕ ПОСТУПЛЕНИЯ","распродажа"));
        $$("h2").shouldHave(exactTextsCaseSensitiveInAnyOrder("Интернет магазин","НОВЫЕ ПОСТУПЛЕНИЯ","РАСПРОДАЖА"));

        List<String> dynamicTexts = new ArrayList<>();
        dynamicTexts.add("Интернет магазин");
        dynamicTexts.add("НОВЫЕ ПОСТУПЛЕНИЯ");
        dynamicTexts.add("Распродажа");

//        List<String> dynamicTexts11 = List.of("Интернет магазин","НОВЫЕ ПОСТУПЛЕНИЯ","РАСПРОДАЖА");

        $$("h2").shouldHave(textsInAnyOrder(dynamicTexts));
//        $$("h2").shouldHave(textsInAnyOrder(dynamicTexts11));

//        $$("abrakadbra").shouldHave(texts("abc"));

    }
}
