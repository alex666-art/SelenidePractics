package ru.skillbox.vinogradov.widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class SearchArticle {

    SelenideElement searchInput=$("header input[name=s]");

    public void searchFor(String article){
        searchInput.setValue(article).pressEnter();
    }

}
