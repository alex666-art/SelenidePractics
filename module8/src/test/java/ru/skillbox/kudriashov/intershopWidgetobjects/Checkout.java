package ru.skillbox.kudriashov.intershopWidgetobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Checkout {

    SelenideElement firstName = $("#billing_first_name");
    SelenideElement lastName = $("#billing_last_name");
    SelenideElement orderAddress = $("#billing_address_1");
    SelenideElement orderCity = $("#billing_city");
    SelenideElement orderRegion = $("#billing_state");
    SelenideElement orderPostCode = $("#billing_postcode");
    SelenideElement orderPhone = $("#billing_phone");
    SelenideElement orderEmail = $("#billing_email");
    SelenideElement submitButton = $("#place_order");

    public void enterData(String name, String surname, String address, String city, String region, String postCode, String phone, String email) {
        firstName.setValue(name);
        lastName.setValue(surname);
        orderAddress.setValue(address);
        orderCity.setValue(city);
        orderRegion.setValue(region);
        orderPostCode.setValue(postCode);
        orderPhone.setValue(phone);
        orderEmail.setValue(email);
        submitButton.click();
    }
}
