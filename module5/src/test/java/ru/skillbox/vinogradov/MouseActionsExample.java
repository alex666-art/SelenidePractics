package ru.skillbox.vinogradov;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MouseActionsExample {

    @Test
    void clickExample(){
        open("http://intershop2.skillbox.ru");

        $("section#promo-section1 aside").click();

        sleep(5000);
    }

    @Test
    void hoverExample(){
        open("http://intershop2.skillbox.ru");

        $("#menu").$(byText("Каталог")).hover();

        sleep(5000);

    }

    @Test
    void rightClick(){
        open("http://demo.guru99.com/test/simple_context_menu.html");

        $("span.context-menu-one").contextClick();

        sleep(5000);

     }

    @Test
    void doubleClick(){
        open("http://demo.guru99.com/test/simple_context_menu.html");

        $("button").doubleClick();

        sleep(5000);
    }

    @Test
    void rightAndDoubleClicks(){
        open("http://demo.guru99.com/test/simple_context_menu.html");

        $("span.context-menu-one").contextClick();
        $("span.context-menu-one").click(ClickOptions.usingDefaultMethod().offsetX(-10));
        $("button").doubleClick();

        sleep(5000);
    }

}
