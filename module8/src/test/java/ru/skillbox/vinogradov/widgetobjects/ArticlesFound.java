package ru.skillbox.vinogradov.widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class ArticlesFound {

    ElementsCollection articles=$$("#primary .wc-products li");

    public void addFirstArticleToBasket(){
        articles.first().$(".price-cart a").click();
    }
}
