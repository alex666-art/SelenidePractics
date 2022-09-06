package ru.skillbox.kudriashov;

import org.junit.jupiter.api.Test;
import ru.skillbox.kudriashov.notesWidgetobjects.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class NoteTest {

    String todayDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d"));
    String firstHeader = "NewNote";
    String secondHeader = "SecondNote";
    String actualNoteCount = "3";
    String description = "Test test test";

    @Test
    void notesTests() {
        // arrange
        open("http://qa.skillbox.ru/module15/bignotes/#/");

        // assert
        new RightSidebarNotesList().notes.shouldHave(text(todayDate));

        // act
        new WorkSpace().addNote(firstHeader, description);

        // assert
        new RightSidebarNotesList().notesList.first().shouldHave(text(firstHeader));

        // act
        new RightSidebarNotesList().addNote();
        new Popup().addNote(secondHeader, description);

        // assert
        new RightSidebarNotesList().notesList.first().shouldHave(text(secondHeader));

        // act
        new LeftSidebar().goToStatisticsPage();

        // assert
        new Calendar().todayDate.shouldHave(text(actualNoteCount));
        new Calendar().checkYesterdayNotesCount();
    }
}
