package ru.skillbox.kudriashov;

import org.junit.jupiter.api.Test;
import ru.skillbox.kudriashov.widjetobject.*;
import ru.skillbox.kudriashov.widjetobject.basket.Basket;
import ru.skillbox.kudriashov.widjetobject.basket.Summary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EighthModuleTests {

    @Test
    public void exampleTest() {
        // arrange
        open("http://intershop6.skillbox.ru/register/");

        // act
        String username = "sel" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddHHmmss"));
        String email = username + "@ya.ru";
        new Registration().registration(username, email, "selenide123");

        // assert
        new Header().welcomeMessage.shouldHave(text("Привет " + username));

        // act
        new SearchArticle().searchFor("стиральная машина");
        new Goods().addFirstGoodsToBasket();
        new Menu().openMenu("Корзина");

        // assert
        new Basket().basketItems.shouldHave(size(1));
        new Basket().firstItemName.shouldHave(text("Стиральная машина"));
        new Basket().firstItemCount.shouldHave(exactValue("1"));
        new Summary().totalPrice.shouldHave(exactText("22990,00₽"));
    }
}
