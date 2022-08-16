package ru.skillbox.vinogradov;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestProperties {

  // повторяемый?
  @Test
  void amazonTest(){
    // Открыть страницу amazon.com
    open("https://amazon.com");

    // Ввести Harry Potter в поле поиска, нажать Enter
    $("#twotabsearchtextbox").setValue("Harry Potter").pressEnter();

    sleep(5000);

    // Проверка: загрузился список товаров и на первом месте товар с именем Harry Potter
    $$("[data-component-type=s-search-result]").first()
            .shouldHave(text("Harry Potter"));
  }

  // независимый?
  @Test
  void secondAmazonTest(){

    open("https://amazon.com");

    // Ввести Harry Potter в поле поиска, нажать Enter
    $("#twotabsearchtextbox").setValue("Harry Potter").pressEnter();
    // act
    $$("[data-component-type=s-search-result]").first().click();
    // assert something
    // ...
  }
}
