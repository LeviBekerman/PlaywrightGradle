package ui.elements;


import com.microsoft.playwright.Page;

public class ButtonElement extends LocatorAbstract {

    public ButtonElement(Page page, String name) {
        locator = page.locator(name);
    }

    public void click() {
        locator.click();
    }

    public void doubleClick() {
        locator.dblclick();
    }

}
