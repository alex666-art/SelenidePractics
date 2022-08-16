package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.*;

public class ActionsExample {

    @Test
    void actionsExample(){
        actions().moveToElement($("div#product")).clickAndHold().moveByOffset(150,-50).release().perform();

        actions().keyDown(Keys.CONTROL).click($("button")).keyUp(Keys.CONTROL).perform();
    }


}
