package ru.skillbox.kudriashov;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SixModuleTests {

    @Test
    public void internetShopMenuVisibleTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        Configuration.timeout = 500;

        // act
        // assert
        $(withText("Оформление заказа")).shouldBe(visible);

    }

    @Test
    public void internetShopFooterEmailTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        Configuration.timeout = 500;
        // act
        $("html").sendKeys(Keys.END);

        // assert
        $(".banner-text").shouldHave(text("skillbox@skillbox.ru"), Duration.ofSeconds(1));
    }

    @Test
    public void myAccountEmailTest() {
        // arrange
        open("http://intershop2.skillbox.ru/my-account/");
        Configuration.timeout = 500;
        // act
        $("#username").setValue("skillbox@skillbox.ru").pressEnter();

        // assert
        $("#username").shouldHave(value("@"));
        $("#password").should(empty);
        $("#rememberme").shouldBe(disabled).shouldNotBe(checked);
    }

    @Test
    public void myAccountSubmitButtonTest() {
        // arrange
        open("http://intershop2.skillbox.ru/my-account/");
        Configuration.timeout = 500;
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
        Configuration.timeout = 500;
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
        $("input").setValue("APPLE").pressEnter();

        // assert
        $(".products").should(or("Разные товары в поисковой выдаче Watch или iPad", text("iPad"), text("Watch")));
    }

    @Test
    public void extendedHomeWorkTest() {
        // arrange
        open("http://intershop2.skillbox.ru/");
        Configuration.timeout = 500;
        // act

        // assert
        $("#ak-top").scrollTo().shouldBe(visible);
    }
}