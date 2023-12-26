package utils.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import manage.objects.KeyValue;
import org.json.JSONObject;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static manage.objects.KeyValue.convertToMap;
import static utils.api.ApiUtils.joinPathAndParameters;

//@Getter
public abstract class ApiAbstract {
    protected Response body;
    protected JSONObject requestParams = new JSONObject();

    protected void setArrayJSON(JSONObject jsonObject) {
        requestParams = jsonObject;
    }

    protected <T> void post(String url, List<KeyValue<T>> keyValues) {
        body = given().when().post(url, convertToMap(keyValues)).thenReturn();
        body.prettyPrint();
    }

    protected <T> void post(String url, ContentType contentType, List<File> files) {
        files.forEach(file ->  given().contentType(contentType).multiPart("files[]", file).post(url).thenReturn());
    }

    protected <T> void getResponseBody(String url, Map<String, String> keyValues) {
        body = given()
                .body(url).get(joinPathAndParameters(url, keyValues)).thenReturn();
    }
}
