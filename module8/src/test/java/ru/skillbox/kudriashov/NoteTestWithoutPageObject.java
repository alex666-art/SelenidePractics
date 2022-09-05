package ru.skillbox.kudriashov;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class NoteTestWithoutPageObject {

    @Test
    void notesTests() {
        // arrange
        open("http://qa.skillbox.ru/module15/bignotes/#/");
        String todayDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d"));

        // assert
        $(".vb-content").shouldHave(text(todayDate));

        // act
        $(".baseInput__field").setValue("NewNote");
        $(".baseTextarea__text").setValue("Test test test");
        $(".pageCreate__baseButton").click();
        // assert
        $$(".pageCreate__articlePreview").first().shouldHave(text("NewNote"));

        // act
        $(".pageCreate__baseButtonAdd").click();
        $(".popup__content .baseInput__field").setValue("SecondNote");
        $(".popup__content .baseTextarea__text").setValue("Test test test");
        $(".popup__baseButton").click();

        // assert
        $$(".pageCreate__articlePreview").first().shouldHave(text("SecondNote"));

        // act
        $$(".theLayout__menuItem").last().click();

        // assert
        $(".today .baseCalendar__count").shouldHave(text("3"));
        $(".today").preceding(0).shouldHave(text("1"));
    }
}
