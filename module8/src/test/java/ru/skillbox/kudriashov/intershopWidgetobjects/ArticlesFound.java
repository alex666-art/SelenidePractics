package ru.skillbox.kudriashov.intershopWidgetobjects;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class ArticlesFound {

    ElementsCollection articles=$$("#primary .wc-products li");

    public void addFirstArticleToBasket(){
        articles.first().$(".price-cart a").click();
    }
}
