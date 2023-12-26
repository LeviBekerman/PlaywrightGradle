package manage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import static utils.DateTimeUtils.getCurrentDateTime;
import static utils.DateTimeUtils.getLocalDateTimeBy;

@ExtendWith(AllureExtension.class)
public abstract class BaseTest {
    protected BrowserManager browserManager;
    private final String videoPath = getLocalDateTimeBy(getCurrentDateTime(), "dd-MM-yyyy HH-mm") + "/";

    @BeforeEach
    protected void beforeTest(TestInfo testInfo) {
        String testPath = testInfo.getDisplayName().replace("()", "");
        browserManager = new BrowserManager("", videoPath + testPath);
    }

    @AfterEach
    protected void afterTest() {
        browserManager.closedBrowser();
    }
}
