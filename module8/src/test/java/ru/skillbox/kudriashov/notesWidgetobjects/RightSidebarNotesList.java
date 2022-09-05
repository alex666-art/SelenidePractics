package ru.skillbox.kudriashov.notesWidgetobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RightSidebarNotesList {

    SelenideElement addNoteButton = $(".pageCreate__baseButtonAdd");
    public ElementsCollection notesList = $$(".pageCreate__articlePreview");

    public SelenideElement notes = $(".vb-content");

    public void addNote() {
        addNoteButton.click();
    }

}
