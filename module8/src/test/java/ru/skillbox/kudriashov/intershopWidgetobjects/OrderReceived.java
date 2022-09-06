package ru.skillbox.kudriashov.intershopWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrderReceived {

    public SelenideElement orderHeader = $(".post-title");
    public SelenideElement productName = $(".product-name a");
    public SelenideElement productCount = $(".product-quantity");
    public SelenideElement emailHeader = $(".email");
    public SelenideElement emailCheckHeader = $(".woocommerce-customer-details--email");
    public SelenideElement cityHeader = $("address");
    public SelenideElement paymentMethodHeader = $("td", 3);
    public SelenideElement totalAmount = $(".amount", 3);
}
