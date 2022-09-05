package ru.skillbox.kudriashov.intershopWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrderReceived {

    SelenideElement orderHeader = $(".post-title");
    SelenideElement productName = $(".product-name a");
    SelenideElement productCount = $(".product-quantity");
    SelenideElement emailHeader = $(".email");
    SelenideElement emailCheckHeader = $(".woocommerce-customer-details--email");
    SelenideElement cityHeader = $("address");
    SelenideElement paymentMethodHeader = $("td", 3);
    SelenideElement totalAmount = $(".amount", 3);
}
