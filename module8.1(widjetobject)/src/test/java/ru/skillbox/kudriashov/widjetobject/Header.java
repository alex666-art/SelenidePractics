package ru.skillbox.kudriashov.widjetobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Header {

   public SelenideElement welcomeMessage = $("header .welcome-user");

}
