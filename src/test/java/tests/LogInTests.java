package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import service.WebDriverService;

public class LogInTests extends WebDriverService {

    private LogInPage page;
    private final String testEmail = "test@test.test";
    private final String testPassword = "test";

    @BeforeMethod
    void setUp() {
        page = new LogInPage();
        Selenide.open("file:///" + htmlTaskFile.getAbsolutePath());
    }

    @Test
    void checkLogInSuccessTest() {
        page
                .fillEmail(testEmail)
                .fillPassword(testPassword)
                .clickAuthSuccess()
                .checkIfOpened();
    }

    @Test
    void checkWrongFormatLogInFailureTest() {
        page
                .fillEmail("1")
                .fillPassword("1")
                .clickAuthFailure()
                .checkErrorText("Неверный формат Email");
    }

    @Test
    void checkWrongEmailLogInFailureTest() {
        page
                .fillEmail("auto@mail.ru")
                .fillPassword("testPassword")
                .clickAuthFailure()
                .checkErrorText("Неверный Email или пароль");
    }

    @Test
    void checkCorrectAccountLogInTest() {
        page
                .fillEmail(testEmail)
                .fillPassword(testPassword)
                .clickAuthSuccess()
                .checkIfOpened()
                .checkCorrectAccount(testEmail);
    }

}