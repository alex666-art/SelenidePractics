package ru.skillbox.vinogradov;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class SelenideDiagnostics {

  void someTest() {
    // Открыть страницу amazon.com
    open("https://amazon.com");
    // Ввести Harry Potter в поле поиска, нажать Enter
    $("#twotabsearchtextbox").setValue("Harry Potter").pressEnter();
    // Проверка: загрузился список товаров и на первом месте товар с именем Harry Potter
    $$("[data-component-type=s-search-result]").first().shouldHave(Condition.text("Harry Potter"));
  }
}
