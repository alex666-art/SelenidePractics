package ru.skillbox.vinogradov.widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Menu {

    SelenideElement menu=$("#menu-primary-menu");

    public void openMenu(String name){
        menu.find(byText(name)).click();
    }
}
