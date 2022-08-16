package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DropdownRadioCheckboxExample {

    @Test
    void dropdownClassic(){
        open("https://the-internet.herokuapp.com/dropdown");

        $("#dropdown").selectOption("Option 2");
        sleep(5000);
        $("#dropdown").selectOption(1);
        sleep(5000);
        $("#dropdown").selectOptionByValue("2");
        sleep(5000);
        $("#dropdown").selectOptionContainingText("tion 1");
        sleep(5000);

        //$("#dropdown").selectOption("Option 2","Option 1");
    }

    @Test
    void radiobuttonClassic(){
        open("http://demo.guru99.com/test/radio.html");

        $("input[name=webform]").selectRadio("Option 2");
        sleep(5000);

        $("#vfb-7-3").click();
        sleep(5000);
    }

    @Test
    void checkboxClassic(){
        open("http://demo.guru99.com/test/radio.html");

        $("input#vfb-6-0").setSelected(true);
        sleep(5000);
        $("input#vfb-6-0").setSelected(false);
        sleep(5000);

        $("input#vfb-6-0").click();
        sleep(5000);
    }

    @Test
    void modernDropdown(){
        open("https://material.angular.io/components/select/examples");

        $("mat-select#mat-select-2").click();
        //$("mat-option#mat-option-8").click();
        $("div#cdk-overlay-0").$(byText("Option 3")).click();
        sleep(5000);
    }

    @Test
    void modernRadiobutton(){
        open("https://material.angular.io/components/radio/examples");
        
        //$("input[type=radio]").selectRadio("Summer");
        $("mat-radio-group").$(byText("Summer")).click();
        sleep(5000);


    }

    @Test void modernCheckbox(){
        open("https://material.angular.io/components/checkbox/examples");

        //$("checkbox-configurable-example mat-checkbox input[type=checkbox]").setSelected(true);
        $("checkbox-configurable-example").$(byText("Checked")).click();
        sleep(5000);
    }
}
