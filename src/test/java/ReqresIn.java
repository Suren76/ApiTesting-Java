import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import response.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresIn {
    static RequestSpecification spec;
    private static final String token = "c01cff63bb463aa8ea208d08eae4f01e31f3be301c3c16c813543d4e8c65554e";
    private static final String baseUrl = "https://gorest.co.in/public/v2";

    static void setup(){
        spec = new RequestSpecBuilder().build()
                .baseUri(baseUrl)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .auth().oauth2(token);
    }

    List<User> userGet(){
        return given().
                spec(spec).
                get("/users").
                as(new TypeRef<List<User>>(){});
    }

    User userPost(request.User user){
        return given().
                spec(spec).
                body(user).
                post("/users").
                as(User.class);
    }

    User userPost(){
        return userPost(new request.User(
                "smbulic760",
                "male",
                "active",
                "smbulic760@testmail.com"));
    }


    User userPut(User user){

        return given().spec(spec).
                body(user).
                put("/users/%s".formatted(user.getId())).
                as(User.class);
    }

    User userPatch(String data, int id){

        return given().spec(spec).
                body(data).
                patch("/users/%s".formatted(id)).
                as(User.class);
    }

    void userDelete(int id){
        String i = given().spec(spec).
                delete("/users/%s".formatted(id)).asString();
    }

    void userDelete(User user) {
        userDelete(user.getId());
    }
}
