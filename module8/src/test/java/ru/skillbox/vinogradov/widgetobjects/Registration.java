package ru.skillbox.vinogradov.widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class Registration {

    // elements
    SelenideElement usernameInput=$("#reg_username");
    SelenideElement emailInput=$("#reg_email");
    SelenideElement passwordInput=$("#reg_password");
    SelenideElement registerBtn=$("button[name=register]");

    // actions
    public void register(String username, String email, String password){
        usernameInput.setValue(username);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        registerBtn.click();
    }
}
