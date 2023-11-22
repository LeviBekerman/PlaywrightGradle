package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AllureReportUtils {

    public static void allureVid(String videoPath) {
        try {
            byte[] byteArr = IOUtils.toByteArray(new FileInputStream(new File(videoPath).listFiles()[0].getAbsolutePath()));
            Allure.addAttachment("attachment name", "video/mp4", new ByteArrayInputStream(byteArr), "mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "logs", type = "text/html", fileExtension = ".txt")
    public static byte[] addAllureTxtAttachment(String logs) {
        return logs.getBytes();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] screenshot(Page page) {
        return page.screenshot();
    }



//    public void beforeTestStop(TestResult result) {
//        if (Status.FAILED == result.getStatus() || Status.BROKEN == result.getStatus()) {
//
//        }
//    }


    public static String getAllureTestUUID() {
        return Allure.getLifecycle().getCurrentTestCase().orElse("");
    }
}
