package services;


import exceptions.InvalidInputs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.SimpleRequestBody;
import models.response.InvalidResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {
    private static final String token = "c01cff63bb463aa8ea208d08eae4f01e31f3be301c3c16c813543d4e8c65554e";
    private static final String baseUrl = "https://gorest.co.in";

    protected static RequestSpecification spec = new RequestSpecBuilder().build()
            .baseUri(baseUrl)
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .auth().oauth2(token);


    // models.BaseModel - is there more correct <type> to be in BaseService ?

    public Response get(String urlPath) {
        return given().get(urlPath);
    }

    public Response post(String urlPath, models.BaseModel user) {
        return checkResponseValidation(given().
                body(user).
                post(urlPath), user);
    }

    public Response put(String urlPath, models.BaseModel user) {
        return checkResponseValidation(given().
                body(user).
                put(urlPath), user);
    }

    public Response patch(String urlPath, Map<String, Object> data) {
        return checkResponseValidation(given().
                body(data).
                patch(urlPath), new SimpleRequestBody(data));
    }

    public Response delete(String urlPath) {
        return given().delete(urlPath);
    }


    // bad solution
    private Response checkResponseValidation(Response response, models.BaseModel requestBody) {
        if (response.statusCode() == 422) {
            var list = response.jsonPath().getList("", InvalidResponse.class);

            for (var i : list) {
                i.setRequestBodyErrorField((String) requestBody.getMap().get(i.getField()));
            }

            if (list.size() > 1) throw new InvalidInputs(list);
            throw InvalidResponse.getException(list.get(0));
        }

        return response;
    }
}
