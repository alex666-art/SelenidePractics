package ru.skillbox.kudriashov.notesWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Popup {
    SelenideElement headerInput = $(".popup__content .baseInput__field");
    SelenideElement descriptionInput = $(".popup__content .baseTextarea__text");
    SelenideElement addNoteButtonPopup = $(".popup__baseButton");

    public void addNote(String header, String description) {
        headerInput.setValue(header);
        descriptionInput.setValue(description);
        addNoteButtonPopup.click();
    }
}
