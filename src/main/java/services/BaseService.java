package services;

import exceptions.UserExists;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {
    private static final String token = "c01cff63bb463aa8ea208d08eae4f01e31f3be301c3c16c813543d4e8c65554e";
    private static final String baseUrl = "https://gorest.co.in";
    protected static RequestSpecification spec;

    // models.BaseModel - is there more correct <type> to be in BaseService

    public static void setup(){
        spec = new RequestSpecBuilder().build()
                .baseUri(baseUrl)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .auth().oauth2(token);
    }

    public Response get(String urlPath){
        return given().get(urlPath);
    }

    public Response post(String urlPath, models.BaseModel user){
        var request = given().
                body(user).
                post(urlPath);

        // bad solution
        if (request.statusCode() == 422) throw new UserExists(request.asString());

        return request;
    }

    public Response put(String urlPath, models.BaseModel user){
        return given().
                body(user).
                put(urlPath);
    }

    public Response patch(String urlPath, String data){
        return given().
                body(data).
                patch(urlPath);
    }

    public Response delete(String urlPath){
        return given().delete(urlPath);
    }

}
