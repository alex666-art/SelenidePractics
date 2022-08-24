package ru.skillbox.kudriashov.widjetobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Registration {

    // elements
    SelenideElement usernameInput = $("#reg_username");
    SelenideElement emailInput = $("#reg_email");
    SelenideElement passwordInput = $("#reg_password");
    SelenideElement submitButton = $("button[name=register]");

    // actions
    public void registration(String username, String email, String password) {
        usernameInput.setValue(username);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        submitButton.click();
    }
}
