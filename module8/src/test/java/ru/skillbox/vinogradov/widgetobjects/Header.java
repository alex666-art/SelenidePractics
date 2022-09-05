package ru.skillbox.vinogradov.widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class Header {

    public SelenideElement welcomeMsg= $("header .welcome-user");
}
