package manage;

import com.microsoft.playwright.*;
import io.qameta.allure.Step;

import java.nio.file.Paths;

import static com.microsoft.playwright.Playwright.create;
import static utils.AllureReportUtils.allureVid;

public class BrowserManager {

    private final Playwright playwright;
    private Browser browser;
    private final BrowserContext context;
    public Page page;
    private final String videoPath;

    public BrowserManager(String browserType, String testName) {
        playwright = create();
        initBrowserType(browserType);
        videoPath = "./videosTest/" + testName;
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get(videoPath)));
        page = context.newPage();
    }

    protected void closedBrowser() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
        allureVid(videoPath);

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

    @Step("Navigate to {}")
    public void navigateTo(String url) {
        page.navigate(url);
    }
}
