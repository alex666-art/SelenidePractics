package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ShouldExamples {

    @Test
    void shouldTests(){
        open("http://intershop2.skillbox.ru/");

        $("h1.site-title").shouldBe(visible);
        $("h1.site-title").shouldHave(text("Skillbox"));
        $("h1.site-title").should(appear);

        $("h1.site-title").shouldBe(visible)
                .shouldHave(text("Skillbox"))
                .should(appear);

        $("h1.site-title").shouldNotBe(hidden);
        $("h1.site-title").shouldHave(text("Google"));
        $("h1.site-title").shouldNot(disappear);


    }
}
