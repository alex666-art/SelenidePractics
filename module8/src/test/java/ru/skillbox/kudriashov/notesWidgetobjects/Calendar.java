package ru.skillbox.kudriashov.notesWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {

    SelenideElement todayDate = $(".today");

    public void getYesterdayNotesCount() {
        todayDate.preceding(0).shouldHave(text("1"));
    }
}
