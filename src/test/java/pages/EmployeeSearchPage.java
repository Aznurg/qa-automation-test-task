package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import mappers.Employee;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EmployeeSearchPage {

    private final SelenideElement pageHeader = $x("//div[@class = 'app-header']");
    private final SelenideElement userInfo = $x("//strong[@id = 'authUserEmail']");
    private final SelenideElement emailSearchInput = $("[name = 'searchEmail']");
    private final SelenideElement nameSearchInput = $("[name = 'searchName']");
    private final SelenideElement genderSearchInput = $("[name = 'searchGender']");
    private final SelenideElement ageSearchInput = $("[name = 'searchAge']");
    private final SelenideElement dateFromSearchInput = $("[name = 'searchDateFrom']");
    private final SelenideElement dateToSearchInput = $("[name = 'searchDateTo']");

    private final SelenideElement searchButton = $("[id = 'searchButton']");
    private final SelenideElement resetButton = $("[id = 'resetSearchButton']");

    private final SelenideElement skillCheckboxSelenium = $("[id = 'searchSkillSelenium']");
    private final SelenideElement skillCheckboxApi = $("[id = 'searchSkillApi']");
    private final SelenideElement skillCheckboxSql = $("[id = 'searchSkillSql']");
    private final SelenideElement skillCheckboxJs = $("[id = 'searchSkillJs']");
    private final SelenideElement skillCheckboxJava = $("[id = 'searchSkillJava']");
    private final SelenideElement skillCheckboxManual = $("[id = 'searchSkillManual']");
    private final SelenideElement skillCheckboxUi = $("[id = 'searchSkillUi']");

    private final ElementsCollection resultsTable = $$x("//table[@id = 'resultsTable']/tbody/tr");

    public EmployeeSearchPage checkIfOpened() {
        pageHeader
                .shouldBe(visible)
                .shouldHave(text("Поиск сотрудников"));

        return this;
    }

    public EmployeeSearchPage checkCorrectAccount(String account) {
        userInfo
                .shouldBe(visible)
                .shouldHave(text(account));

        return this;
    }

    public EmployeeSearchPage fillEmail(String email) {
        emailSearchInput
                .shouldBe(visible, enabled)
                .sendKeys(email);

        return this;
    }

    public EmployeeSearchPage fillName(String name) {
        nameSearchInput
                .shouldBe(visible, enabled)
                .sendKeys(name);

        return this;
    }

    public EmployeeSearchPage chooseGender(Boolean isWoman) {
        genderSearchInput
                .shouldBe(visible, enabled)
                .click();
        $x("//option[text() = '" + (isWoman ? "Женский" : "Мужской") + "']").click();

        return this;
    }

    public EmployeeSearchPage fillAge(String age) {
        ageSearchInput
                .shouldBe(visible, enabled)
                .sendKeys(age);

        return this;
    }

    public EmployeeSearchPage fillDateFrom(String dateFrom) {
        dateFromSearchInput
                .shouldBe(visible, enabled)
                .sendKeys(dateFrom);

        return this;
    }

    public EmployeeSearchPage fillDateTo(String dateTo) {
        dateToSearchInput
                .shouldBe(visible, enabled)
                .sendKeys(dateTo);

        return this;
    }

    public EmployeeSearchPage clickSearchButton() {
        searchButton.click();

        return this;
    }

    public List<Employee> getTableData() {
        List<Employee> employees = new ArrayList<>();

        for (SelenideElement date : $$x("//tbody/tr")) {
            employees.add(new Employee(date.$$x(".//td").texts()));
        }

        return employees;
    }

    /* добавил не все проверки, осталось добавить методы для кликов на чекбоксы,
    проверку изменения их активности (хотя у них здесь нет такого поля).
     Плюс, проверка сброса фильтра, проверка выпадающих календарей, проверка выхода*/

}
