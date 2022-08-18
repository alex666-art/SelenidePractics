package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ConditionsExamples {

    @Test
    void visibilityConditions(){

        open("http://intershop2.skillbox.ru/");

        $("h1.site-title").shouldBe(visible);
        $("h1.site-title").should(appear);

        $("h1.site-title").shouldNotBe(hidden);
        $("h1.site-title").shouldNot(disappear);

    }

//    @Test
//    void textConditions(){
//
//        open("http://intershop2.skillbox.ru/");
//
//        var product=$("#accesspress_store_product-2").$$("li").find(visible);
//
//        product.shouldHave(text("Скидка!")); // Скидка, СКИДКА, СкИдКа
//        product.shouldHave(textCaseSensitive("Скидка!")); // проверка с текстом нижнего регистра
//
//        product.$("span.onsale").shouldHave(exactText("Скидка!")); // Скидка, СКИДКА, СкИдКа (проверка содержащая текст)
//        product.$("span.onsale").shouldHave(exactTextCaseSensitive("Скидка!")); // текст должен полностью совпадать с ожидаемым
//
//        product.$("del span").shouldHave(ownText(",00")); // поиск части текста элемента без учёта текста потомков
//        product.$("del span").shouldHave(exactOwnText("72530,00")); // поиск полного совпадения текста элемента без учёта текста потомков
//
//        product.$("del span").should(matchText("^[0-9].*")); // проверка с помощью регулярного выражения
//    }

    @Test
    void inputConditions(){

        open("http://intershop2.skillbox.ru/");

        $("[name=s]").setValue("123");

        $("[name=s]").shouldHave(value("23"));
        $("[name=s]").shouldHave(exactValue("123"));

        $("[name=s]").clear();
        $("[name=s]").shouldBe(empty);

    }

    @Test
    void dropdownConditions(){

        open("http://qajava.skillbox.ru/search.html");

        $("select[name=year]").selectOption("2010");
        $("select[name=year] option[value='2010']").shouldBe(selected);

    }

    @Test
    void checkboxConditions(){

        open("http://intershop6.skillbox.ru/my-account/");

        $("#rememberme").setSelected(true);
        $("#rememberme").shouldBe(checked);


    }

    @Test
    void disabledConditions(){

        open("http://intershop2.skillbox.ru/my-account/");

        $("#rememberme").shouldBe(disabled);

        $("#rememberme").shouldBe(enabled);

    }

    @Test
    void visiualConditions(){
        open("http://intershop2.skillbox.ru/");

        $("div#menu li").shouldHave(cssClass("current-menu-item"));

        $("div#menu li a").shouldHave(cssValue("text-decoration-color","rgb(226, 69, 69)"));
    }

    @Test
    void otherConditions(){
        open("http://intershop2.skillbox.ru/");

        $("#colophon").shouldHave(attribute("role"));
        $("#colophon").shouldHave(attribute("role","contentinfo"));

        $("#colophon").shouldHave(attributeMatching("role",".*info$"));

        $("input[name=post_type]").should(exist);
    }
}
