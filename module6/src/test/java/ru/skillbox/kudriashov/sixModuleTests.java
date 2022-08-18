package ru.skillbox.kudriashov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class sixModuleTests {

    @Test
    public void internetShopMenuVisibleTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        Configuration.timeout = 1000;

        // act
        // assert
        $("#menu-item-31").shouldBe(visible);

    }

    @Test
    public void internetShopFooterEmailTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        Configuration.timeout = 1000;
        // act
        $("html").sendKeys(Keys.END);

        // assert
        $(".text-5-value", 1).shouldHave(text("skillbox@skillbox.ru"));
    }

    @Test
    public void myAccountEmailTest() {
        // arrange
        open("http://intershop2.skillbox.ru/my-account/");
        Configuration.timeout = 1000;
        // act
        $("#username").setValue("skillbox@skillbox.ru");
        $("#username").sendKeys(Keys.ENTER);
        // assert
        $("#username").shouldHave(value("@"));
        $("#password").should(empty);
        $("#rememberme").shouldBe(disabled);
    }

    @Test
    public void myAccountSubmitButtonTest() {
        // arrange
        open("http://intershop2.skillbox.ru/my-account/");
        Configuration.timeout = 1000;
        // act
        $(".custom-register-button").hover();

        // assert
        $(".custom-register-button").shouldHave(cssValue("background-color", "rgba(226, 69, 69, 1)"));

        // act
        $("#rememberme").hover();

        // assert
        $(".custom-register-button").shouldHave(cssValue("background-color", "rgba(255, 255, 255, 1)"));
        $("button[name=login]").shouldHave(cssClass("woocommerce-button"));
    }

    @Test
    public void myAccountHiddenElementTest() {
        // arrange
        open("http://intershop2.skillbox.ru/my-account/");
        Configuration.timeout = 1000;
        // act
        // assert
        $("input[name=_wp_http_referer]").should(exist);
        $("input[name=_wp_http_referer]").shouldHave(value("/my-account/"));
    }

    @Test
    public void mainPageSearchTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");

        // act
        $("input").setValue("APPLE").sendKeys(Keys.ENTER);

        // assert
        $(".products").shouldHave(text("Watch"));
    }

    @Test
    public void extendedHomeWorkTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        Configuration.timeout = 500;
        // act
        $("html").sendKeys(Keys.END);
        // assert
        $("#ak-top").shouldBe(visible);
    }
}