package ru.skillbox.kudriashov.intershopWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    public SelenideElement welcomeMsg= $("header .welcome-user");
}
