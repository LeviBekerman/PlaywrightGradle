package manage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    protected BrowserManager browserManager;

    @BeforeEach
    protected void beforeTest() {
        browserManager = new BrowserManager();
    }

    @AfterEach
    protected void afterTest() {
        browserManager.closedBrowser();
    }
}
