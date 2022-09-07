package ru.skillbox.kudriashov.intershopWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Menu {

    SelenideElement menu= $("#menu-primary-menu");

    public void openMenu(String name){
        menu.find(byText(name)).click();
    }
}
