package ru.skillbox.kudriashov.notesWidgetobjects;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class LeftSidebar {

    ElementsCollection leftSidebarButtons =  $$(".theLayout__menuItem");

    public void goToStatisticsPage() {
        leftSidebarButtons.last().click();
    }
}
