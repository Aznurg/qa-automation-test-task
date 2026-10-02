package tests;

import com.codeborne.selenide.Selenide;
import mappers.Employee;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmployeeSearchPage;
import pages.LogInPage;
import service.WebDriverService;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class EmployeeSearchTests extends WebDriverService {

    private final EmployeeSearchPage page = new EmployeeSearchPage();
    private final String testEmail = "test@test.test";
    private final String testPassword = "test";

    @BeforeMethod
    void setUp() {
        Selenide.open("file:///" + htmlTaskFile.getAbsolutePath());
        new LogInPage()
                .fillEmail(testEmail)
                .fillPassword(testPassword)
                .clickAuthSuccess()
                .checkIfOpened();
    }

    @Test
    void checkNameFilterTest() {
        List<Employee> employeeList =
                page
                .fillName("Иван")
                .clickSearchButton()
                .getTableData();

        employeeList.forEach(it ->
                assertTrue(it.getName().contains("Иван")));
    }
    /* по такой же логике, как в тесте выше,
    можно проверять каждое из полей фильтрации отдельно или вместе,
    либо жонглировать объектом клиента, как душе угодно */
}
