package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import java.time.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TimeoutExamples {

    @Test
    void timeoutConfiguration(){
        open("http://intershop2.skillbox.ru/");

        Configuration.timeout = 6000;

        $("h2.site-title").shouldBe(visible);
    }


    @Test
    void customTimeout(){
        open("http://intershop6.skillbox.ru/bonus/");

        $("#bonus_username").setValue("Alice");
        $("#bonus_phone").setValue("81234567890");
        $("button[name=bonus]").click();
        $(byText("Ваша карта оформлена!")).shouldBe(visible, Duration.ofSeconds(8));

    }
}
