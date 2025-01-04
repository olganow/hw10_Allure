import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import steps.TestSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static constants.Constants.BASE_URL;
import static constants.Constants.USER_REPOSITORY;
import static constants.Constants.TITLE;


public class AllureTests extends TestBase {


    @Test
    void selenideWithListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(BASE_URL);
        $(".header-search-button").click();
        $("#query-builder-test").setValue(USER_REPOSITORY).pressEnter();
        $x("//a[@href='/olganow/hw10_Allure']").click();
        $("#issues-tab").click();
        $(".container-md").shouldHave(text(TITLE));
    }

    @Test
    void stepsTest() {
        TestSteps steps = new TestSteps();
        steps.openMainPage(BASE_URL);
        steps.searchRepository(USER_REPOSITORY);
        steps.clickRepoLink();
        steps.clickIssuesTab();
        steps.checkTitleName(TITLE);

    }

    @Test
    void lambdaTest() {
        step("Open main page", () -> {
            open(BASE_URL);
        });
        step("Find a repo: " + USER_REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(USER_REPOSITORY).pressEnter();
        });
        step("Click on a repo link: " + USER_REPOSITORY, () -> {
            $x("//a[@href='/olganow/hw10_Allure']").click();
        });
        step("Click on Issues tab", () -> {
            $("#issues-tab").click();
        });
        step("Check a title name: " + TITLE, () -> {
            $(".container-md").shouldHave(text("Welcome to issues!"));
        });

    }

}