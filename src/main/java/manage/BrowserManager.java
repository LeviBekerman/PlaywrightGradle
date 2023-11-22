package manage;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.Playwright.create;

public class BrowserManager {

    private final Playwright playwright;
    private final Browser browser;
    private final BrowserContext context;
    public Page page;

    public BrowserManager() {
        playwright = create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    protected void closedBrowser() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }
}
