package ru.skillbox.kudriashov.widjetobject.basket;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Summary {

   public SelenideElement totalPrice = $("#primary div.cart_totals tr td[data-title=Сумма]");

}
