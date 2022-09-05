package ru.skillbox.kudriashov.notesWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WorkSpace {

    SelenideElement headerInput = $(".baseInput__field");
    SelenideElement descriptionInput = $(".baseTextarea__text");
    SelenideElement addButton = $(".pageCreate__baseButton");

    public void addNote(String header, String description) {
        headerInput.setValue(header);
        descriptionInput.setValue(description);
        addButton.click();
    }
}
