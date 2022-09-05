package ru.skillbox.vinogradov.widgetobjects.basket;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class Totals {
    public SelenideElement totalAmount=$("#primary div.cart_totals tr td[data-title=Сумма]");
}
