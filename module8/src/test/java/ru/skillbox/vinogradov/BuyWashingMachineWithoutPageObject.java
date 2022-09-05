package ru.skillbox.vinogradov;

import org.junit.jupiter.api.*;

import java.time.*;
import java.time.format.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BuyWashingMachineWithoutPageObject {

    @Test
    void customerCanAddWashineMachineToTheBasket(){
        // открыть страницу регистрации нового пользователя
        open("http://intershop6.skillbox.ru/register");
        // зарегистрировать пользователя
        String username = "sel" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddHHmmss"));
        String email=username+"@ya.ru";
        $("#reg_username").setValue(username);
        $("#reg_email").setValue(email);
        $("#reg_password").setValue("selenide123");
        $("button[name=register]").click();
        // check: приветствие отображается вверху страницы: Привет selenide...
        $("header .welcome-user").shouldHave(text("Привет "+username));
        // искать в товарах "стиральная машина"
        $("header input[name=s]").setValue("стиральная машина").pressEnter();
        // положить в корзину первую стиральную машину из списка
        $$("#primary .wc-products li").first().$(".price-cart a").click();
        // зайти в корзину
        $("#menu-primary-menu").$(byText("Корзина")).click();
        // check: в корзине - 1 стиральная машина
        $$("#primary tr.cart_item").shouldHave(size(1));
        $("#primary tr.cart_item td[data-title=Товар]").shouldHave(text("Стиральная машина"));
        $("#primary tr.cart_item td[data-title=Количество] input").shouldHave(exactValue("1"));
        // check: итоговая цена заказа 22990 р.
        $("#primary div.cart_totals tr td[data-title=Сумма]").shouldHave(exactText("22990,00₽"));
    }
}
