package module05;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class fifthHomeWorkTests {

    @Test
    public void calendarSelectDateTest() {
        // arrange
        open("http://qa.skillbox.ru/module11/practice/feedbacksingle/");

        // act
        $(".vdp-datepicker").click();
        $(Selectors.byText("13")).hover();
        sleep(5000);

        //assert
    }

    @Test
    public void languageSchoolFormTest() {
        // arrange
        open("https://lm.skillbox.cc/qa_tester/module08/practice2/");

        // act
        $("input[name=name]").setValue("Alex");
        sleep(2000);

        $("input[name=last__name]").setValue("Petrov");
        sleep(2000);

        $("#sel").$(Selectors.byText("1989")).click();
        sleep(2000);

        $(Selectors.byText("Japanese")).click();
        sleep(2000);

        $(Selectors.byText("Russian")).click();
        sleep(2000);

        $("input[name=last__name]").append("-сан");
        sleep(3000);

        // assert
    }

    @Test
    public void languageSchoolSwitchLanguageTest() {
        // arrange
        open("https://lm.skillbox.cc/qa_tester/module08/practice2/");

        // act
        $(".module__input").$(Selectors.byText("Японский")).click();
        sleep(2000);
        $(".module__input").$(Selectors.byText("ロシア語")).click();
        sleep(2000);
        // assert
    }
}
