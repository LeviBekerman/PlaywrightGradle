package manage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.Playwright.create;

public class BrowserManager {

    private final Playwright playwright;
    private final Browser browser;
    public Page page;

    public BrowserManager() {
        playwright = create();
        browser = playwright.chromium().launch();
        page = browser.newPage();
    }

    protected void closedBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }
}
