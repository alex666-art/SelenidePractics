package ru.skillbox.vinogradov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BrowserExample {

    @BeforeEach
    void init(){
        Configuration.timeout=15000;
    }

    @Test
    void openAndNavigate(){

       open("https://the-internet.herokuapp.com/");

       Configuration.baseUrl="https://the-internet.herokuapp.com";
       open("/dynamic_content");
       sleep(5000);

       open("/basic_auth",AuthenticationType.BASIC,"admin","admin");
       sleep(5000);

       Selenide.back();
       sleep(5000);

       Selenide.refresh();
       sleep(5000);

    }

    @Test
    void cookieAndLocalStorage(){

        open("https://the-internet.herokuapp.com/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    void browserAlerts(){
        open("https://the-internet.herokuapp.com/javascript_alerts");

        $("button").click();
        Selenide.confirm();
        sleep(5000);

        $("button",1).click();
        sleep(3000);
        Selenide.dismiss();
        sleep(5000);
    }

    @Test
    void framesAndWindows(){
        open("http://qajava.skillbox.ru/module5/homework/");
        Selenide.switchTo().frame(0);
        $("input[name=email]").setValue("test@skillbox.ru");
        sleep(5000);
        Selenide.switchTo().defaultContent();
        $(".skb-logo").shouldBe(visible);
        Selenide.switchTo().frame(0).switchTo().frame(0);
        $("div.socialLinks a",2).click();
        sleep(5000);
        Selenide.switchTo().window("skillbox.ru (@skillboxru) / Twitter");
        $("#react-root").shouldBe(visible);
        sleep(5000);


    }

    @Test
    void closeBrowserAndWindows(){
        open("http://qajava.skillbox.ru/module5/homework/");

        Selenide.switchTo().frame(0).switchTo().frame(0);
        $("div.socialLinks a",2).click();
        Selenide.switchTo().window("skillbox.ru (@skillboxru) / Twitter");
        sleep(5000);
        Selenide.closeWindow();
        sleep(5000);

        Selenide.switchTo().window(0);
        Selenide.switchTo().frame(0).switchTo().frame(0);
        $("div.socialLinks a",2).click();
        sleep(5000);
        Selenide.closeWebDriver();

    }
}
