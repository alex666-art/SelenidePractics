package firstHomework;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AmazonTest {

    @Test
    void amazon(){
        // Открыть страницу amazon.com
        open("https://amazon.com");
        // Ввести Harry Potter в поле поиска, нажать Enter
        $("#twotabsearchtextbox").setValue("Harry Potter").pressEnter();
        // Проверка: загрузился список товаров и на первом месте товар с именем Harry Potter
        $$("[data-component-type=s-search-result]").first()
                .shouldHave(text("Harry Potter"));
    }

    @Test
    void intershop(){
        // Открыть страницу intershop.skillbox.ru
        open("http://intershop.skillbox.ru/");
        // Ввести Машина в поле поиска, нажать Enter
        $(".search-field").setValue("Машина").pressEnter();
        // Проверка: загрузился список товаров и на первом месте товар с в котором присутствует слово Машина
        $$(".type-product").first()
                .shouldHave(text("машина"));
    }

}
