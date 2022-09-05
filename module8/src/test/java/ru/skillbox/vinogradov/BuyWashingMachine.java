package ru.skillbox.vinogradov;

import org.junit.jupiter.api.*;
import ru.skillbox.vinogradov.widgetobjects.*;
import ru.skillbox.vinogradov.widgetobjects.basket.*;

import java.time.*;
import java.time.format.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BuyWashingMachine {

    @Test
    void customerCanAddWashineMachineToTheBasket(){
        open("http://intershop6.skillbox.ru/register");

        String username = "sel" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddHHmmss"));
        String email=username+"@ya.ru";
        new Registration().register(username,email,"selenide123");

        new Header().welcomeMsg.shouldHave(text("Привет "+username));

        new SearchArticle().searchFor("стиральная машина");

        new ArticlesFound().addFirstArticleToBasket();
        new Menu().openMenu("Корзина");

        new BasketVin().basketItems.shouldHave(size(1));
        new BasketVin().firstArticleName.shouldHave(text("Стиральная машина"));
        new BasketVin().firstArticleQuantity.shouldHave(exactValue("1"));

        new Totals().totalAmount.shouldHave(exactText("22990,00₽"));


    }
}
