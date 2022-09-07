package ru.skillbox.kudriashov;

import org.junit.jupiter.api.Test;
import ru.skillbox.kudriashov.intershopWidgetobjects.Checkout;
import ru.skillbox.kudriashov.intershopWidgetobjects.OrderReceived;
import ru.skillbox.kudriashov.intershopWidgetobjects.basket.Basket;
import ru.skillbox.vinogradov.widgetobjects.*;
import ru.skillbox.vinogradov.widgetobjects.basket.BasketVin;
import ru.skillbox.vinogradov.widgetobjects.basket.Totals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class BuyWashingMachine {
    String username = "sel" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddHHmmss"));
    String email = username + "@ya.ru";
    String name = "John";
    String surname = "Doe";
    String address = "Downing street 456";
    String city = "London";
    String region = "Capital city";
    String postCode = "40000";
    String phone = "+9631784567";

    @Test
    void customerCanAddWashingMachineToTheBasket() {
        // arrange
        open("http://intershop6.skillbox.ru/register");

        // act
        new Registration().register(username, email, "selenide123");

        // assert
        new Header().welcomeMsg.shouldHave(text("Привет " + username));

        // act
        new SearchArticle().searchFor("стиральная машина");
        new ArticlesFound().addFirstArticleToBasket();
        new Menu().openMenu("Корзина");

        // assert
        new BasketVin().basketItems.shouldHave(size(1));
        new BasketVin().firstArticleName.shouldHave(text("Стиральная машина"));
        new BasketVin().firstArticleQuantity.shouldHave(exactValue("1"));
        new Totals().totalAmount.shouldHave(exactText("22990,00₽"));

        // act
        new Basket().goToPay();
        new Checkout().enterData(name, surname, address, city, region, postCode, phone, email);

        // assert
        new OrderReceived().orderHeader.shouldHave(text("Заказ получен"));
        new OrderReceived().productName.shouldHave(text("LG FH0C3ND"));
        new OrderReceived().productCount.shouldHave(text("1"));
        new OrderReceived().emailHeader.shouldHave(text(email));
        new OrderReceived().emailCheckHeader.shouldHave(text(email));
        new OrderReceived().cityHeader.shouldHave(text(city));
        new OrderReceived().paymentMethodHeader.shouldHave(text("Прямой банковский перевод"));
        new OrderReceived().totalAmount.shouldHave(text("22990,00"));
    }
}
