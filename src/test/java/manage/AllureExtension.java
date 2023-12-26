package manage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.*;
import utils.api.ApiAbstract;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.http.ContentType.MULTIPART;
import static utils.StringUtils.encodingBase64;
import static utils.api.ApiUtils.joinPathAndParameters;
import static utils.files.Files.getAllFiles;
import static utils.files.ReadFile.contentFile;

public class AllureExtension extends ApiAbstract implements AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) {
        RestAssured.baseURI = "http://localhost:5050/allure-docker-service";
        final String ARRAY_RESULTS_NAME = "results";
        final String PROJECT_ID = "mendi";
        List<File> filesToSend = getAllFiles(new File("./build/allure-results"));
        JSONObject contentFilesResults = new JSONObject();
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> keyValues = Map.of(
                "project_id", PROJECT_ID,
                "force_project_creation", "true");

//        filesToSend.forEach(file -> {
//            Map<String, ?> newContentFiles = new HashMap<>();
//            newContentFiles.put("file_name", file.getName());
//            newContentFiles.put("content_base64", encodingBase64(contentFile(file)));
//            mapList.add(newContentFiles);
//        });
        contentFilesResults.put(ARRAY_RESULTS_NAME, mapList);
        setArrayJSON(contentFilesResults);
        post(joinPathAndParameters("send-results", keyValues), MULTIPART, filesToSend );
        getResponseBody("generate-report", Map.of("project_id", PROJECT_ID));
    }
}
