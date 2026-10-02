package service;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import reporting.Report;

import java.io.File;

public abstract class WebDriverService {

    protected File htmlTaskFile = new File("src/test/task.html");

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        SessionId sessionId = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId();
        Selenide.closeWebDriver();
        Report.attachSessionInfo(sessionId);
    }
}
