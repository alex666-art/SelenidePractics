package ru.skillbox.vinogradov;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ThirdModuleTests {

    @Test
    public void firstInternetShopTitleTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        // act
        $(Selectors.byText("Мой аккаунт")).click();
        // assert
        $(".post-title").shouldHave(Condition.text("Мой аккаунт"));
        // act
        $(".custom-register-button").click();
        // assert
        $(".post-title").shouldHave(Condition.text("Регистрация"));
        // act
        $(Selectors.byText ("Главная")).click();
        // assert
        $(".post-title").shouldNotHave(Condition.visible);
    }

    @Test
    public void secondInternetShopTitleTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        // act
        $(Selectors.byText("Мой аккаунт")).click();

        // act
        $(".custom-register-button").click();

        // act
        $(Selectors.byText ("Главная")).click();
        // assert
        $(".post-title").shouldNotHave(Condition.visible);
    }

    @Test
    public void findIdFinishText() {
        // arrange
        open("https://lm.skillbox.cc/qa_tester/module07/homework1/");

        // assert
        //$("#finish").shouldHave(Condition.text("Телефон"));
        $("#page_1").shouldHave(Condition.text(("Телефон")));
    }
}
