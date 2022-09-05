package ru.skillbox.vinogradov.widgetobjects.basket;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class BasketVin {

    public ElementsCollection basketItems=$$("#primary tr.cart_item");
    public SelenideElement firstArticleName=$("#primary tr.cart_item td[data-title=Товар]");
    public SelenideElement firstArticleQuantity =$("#primary tr.cart_item td[data-title=Количество] input");
}
