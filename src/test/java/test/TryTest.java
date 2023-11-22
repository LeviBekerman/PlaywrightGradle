package test;

import io.qameta.allure.*;
import manage.BaseTest;
import manage.BrowserManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.elements.ButtonElement;
import ui.elements.TextInputElement;

import static io.qameta.allure.SeverityLevel.CRITICAL;


public class TryTest extends BaseTest {

    @Test
    @DisplayName("Test Authentication")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void on() {
        getCode(browserManager,"1email@gmail.com");
    }


    @Test
    public void tow() {
        getCode(browserManager,"2email@gmail.com");
    }


    @Test
    public void three() {
        getCode(browserManager,"3email@gmail.com");
    }

    @Test
    public void fore() {
        getCode(browserManager,"4email@gmail.com");
    }

    private void getCode(BrowserManager browserManager, String email) {

        browserManager.navigateTo("https://019mobile.co.il/userarea/");
        TextInputElement userNameOrPhoneNumberTextInput = new TextInputElement(browserManager.page, "xpath=//input[@aria-label='הכניסו את כתובת המייל\\מספר הטלפון']");
        ButtonElement buttonElement = new ButtonElement(browserManager.page, "xpath=//button[text()='שלחו לי קוד בדוא\"ל']");
        userNameOrPhoneNumberTextInput.type(email);
        buttonElement.click();

    }
}

