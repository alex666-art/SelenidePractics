package ru.skillbox.kudriashov.widjetobject;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class Goods {

    ElementsCollection goods = $$("#primary .wc-products li");

    public void addFirstGoodsToBasket() {
        goods.first().$(".price-cart a").click();
    }
}
