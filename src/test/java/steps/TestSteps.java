package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestSteps {

    @Step("Open main page")
    public void openMainPage(String URL) {
        open(URL);
    }


    @Step("Find {repo}")
    public void searchRepository(String userRepo) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(userRepo).pressEnter();
    }

    @Step("Click on a repo link")
    public void clickRepoLink() {
        $x("//a[@href='/olganow/hw10_Allure']").click();
    }

    @Step("click on Issues")
    public void clickIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Check a title name {title}")
    public void checkTitleName(String title) {
        $(".container-md").shouldHave(text(title));

    }
}