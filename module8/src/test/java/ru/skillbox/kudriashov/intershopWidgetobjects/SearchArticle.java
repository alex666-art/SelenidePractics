package ru.skillbox.kudriashov.intershopWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchArticle {

    SelenideElement searchInput=$("header input[name=s]");

    public void searchFor(String article){
        searchInput.setValue(article).pressEnter();
    }

}
