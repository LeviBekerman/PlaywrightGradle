package ui.elements;


import com.microsoft.playwright.Page;

public class TextInputElement extends LocatorAbstract {

    public TextInputElement(Page page, String name) {
        locator = page.locator(name);
    }

    public void clear() {
        locator.clear();
    }

    public void type(String text) {
        locator.type(text);
    }

}
