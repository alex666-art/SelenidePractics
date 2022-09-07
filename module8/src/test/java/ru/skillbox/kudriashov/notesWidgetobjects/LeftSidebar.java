package ru.skillbox.kudriashov.notesWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class LeftSidebar {

    SelenideElement leftPanelButton =  $(".theLayout__menuBody");

    public void clickLeftPanelButton(String name) {
        leftPanelButton.find(byText(name)).click();
    }
}
