package ru.skillbox.kudriashov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SeventhModule {

    @Test
    public void catalogBooksCountTest() {
        // arrange
        open("http://intershop2.skillbox.ru/product-category/catalog/books/");

        // act

        // assert
        $$(".cat-item").shouldHave(sizeGreaterThan(6)).shouldHave(sizeLessThanOrEqual(13));
    }

    @Test
    public void catalogBooksListTest() {
        // arrange
        open("http://intershop2.skillbox.ru/product-category/catalog/books/");

        // act

        // assert
        $$(".cat-item a").first(3).shouldHave(texts("Без категории", "Бытовая Техника", "Каталог"));
        $$(".cat-item a").shouldHave(containExactTextsCaseSensitive("Телефоны", "Холодильники"));
    }

    @Test
    public void catalogBooksLastCategoryTest() {
        // arrange
        open("http://intershop2.skillbox.ru/product-category/catalog/books/");

        // act

        // assert
        $$(".cat-item").last().shouldHave(text("20"));
    }

    @Test
    public void sumCatalogGoodsTest() {
        // arrange
        open("http://intershop2.skillbox.ru/product-category/catalog/appliances/wash/");
        // act
        // assert
        $$("li").filterBy(attribute("current-cat-parent"));

    }

}
