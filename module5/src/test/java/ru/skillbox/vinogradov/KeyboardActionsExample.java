package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class KeyboardActionsExample {

    @Test
    void inputExample(){
       open("http://intershop2.skillbox.ru");

       $("[name=s]").setValue("Фото");
       sleep(2000);
       $("[name=s]").append("аппарат");
       sleep(2000);
       $("[name=s]").setValue("зеркалка");
       sleep(2000);
       $("[name=s]").clear();
       sleep(5000);

    }


    @Test
    void hotkeys(){
        open("http://intershop2.skillbox.ru");

        $("html").sendKeys(Keys.chord(Keys.COMMAND,"a"));

        sleep(5000);
    }
}
