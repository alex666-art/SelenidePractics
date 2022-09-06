package ru.skillbox.kudriashov.notesWidgetobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class LeftSidebar {

    ElementsCollection leftPanelButton =  $$(".theLayout__menuItem");

    public void goToStatisticsPage() {
        leftPanelButton.last().click(); // ���� �� ������ "����������" � ����� ������
    }
}
