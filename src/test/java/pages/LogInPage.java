package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertTrue;

public class LogInPage {

    private final SelenideElement emailInput = $x("//input[@id = 'loginEmail']");
    private final SelenideElement passwordInput = $x("//input[@id = 'loginPassword']");
    private final SelenideElement authButton = $x("//button[@id = 'authButton']");
    private final SelenideElement errorAlert = $x("//div[@class = 'form-alert']");
    private final SelenideElement errorAlertText = $x("//span[@class = 'form-alert__text']");

    public LogInPage fillEmail(String email) {
        emailInput
                .shouldBe(visible, enabled)
                .sendKeys(email);

        return this;
    }

    public LogInPage fillPassword(String password) {
        passwordInput
                .shouldBe(visible, enabled)
                .shouldHave(attribute("type", "password"))
                /* в форме нет "глазика" для пароля, потому добавил эту проверку
                   сюда, в случае его наличия проверку переключения типа поля ввода
                   (password/text) можно вынести в отдельный тест */
                .sendKeys(password);

        return this;
    }

    public EmployeeSearchPage clickAuthSuccess() {
        authButton
                .shouldBe(visible, enabled)
                .click();

        return new EmployeeSearchPage();
    }

    public LogInPage clickAuthFailure() {
        authButton
                .shouldBe(visible, enabled)
                .click();
        errorAlert
                .shouldBe(visible);

        return this;
    }

    public void checkErrorText(String errorText) {
        errorAlertText
                .shouldBe(visible)
                .shouldHave(text(errorText));
    }

    public void checkFieldsEmpty() {
        assertTrue(
                emailInput
                        .shouldBe(visible)
                        .getText()
                        .isEmpty() &&
                        passwordInput
                                .shouldBe(visible)
                                .getText()
                                .isEmpty());
    }
}
