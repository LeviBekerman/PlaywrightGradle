package manage;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.Playwright.create;

public class BrowserManager {

    private final Playwright playwright;
    private Browser browser;
    private final BrowserContext context;
    public Page page;

    public BrowserManager(String browserType, String testName) {
        playwright = create();
        initBrowserType(browserType);
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./videosTest/" + testName)));
        page = context.newPage();
    }

    protected void closedBrowser() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    private void initBrowserType(String browserType) {

        switch (browserType.toLowerCase()) {
            case "firefox": {
                browser = playwright.firefox().launch();
                break;
            }
            case "webkit": {
                browser = playwright.webkit().launch();
                break;
            }
            default: {
                browser = playwright.chromium().launch();
            }
        }
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }
}
