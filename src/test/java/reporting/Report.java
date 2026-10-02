package reporting;

import org.openqa.selenium.remote.SessionId;

public final class Report {

    private Report() {
    }

    public static void attachSessionInfo(SessionId sessionId) {
        System.out.println("Browser session: " + sessionId);
    }
}