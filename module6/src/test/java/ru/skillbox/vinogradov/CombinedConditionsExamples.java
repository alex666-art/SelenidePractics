package ru.skillbox.vinogradov;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CombinedConditionsExamples {

    @Test
    void andCombinations() {
        open("http://intershop2.skillbox.ru/");

        $("h1").shouldBe(visible)
        .shouldHave(text("Skillbox"),cssClass("site-title"));
    }

    @Test
    void orCombinations() {
        open("http://intershop2.skillbox.ru/");

        $("h1").should(or("Текст заголовка или нужный класс",text("Skillbox2"),cssClass("site-title2")));

    }

}
