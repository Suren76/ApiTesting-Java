package services;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

public class ReqresIn extends BaseService {
    private static final String basePath = "/public/v2";

    public static void setup(){
        BaseService.setup();
        spec.basePath(basePath);

        RestAssured.requestSpecification = spec;
    }

    public List<models.response.User> userGet(){
        return get("/users").as(new TypeRef<List<models.response.User>>(){});
    }

    public models.response.User userPost(models.request.User user){
        return post("/users", user).as(models.response.User.class);
    }

    public models.response.User userPost(){
        return userPost(new models.request.User(
                new Faker().funnyName().name(),
                new Faker().options().nextElement(new String[]{"male","female"}),
                new Faker().options().nextElement(new String[]{"active","inactive"}),
                new Faker().internet().emailAddress()
        ));
    }


    public models.response.User userPut(models.response.User user){
        return put("/user/%s".formatted(user.getId()), user).
                as(models.response.User.class);
    }

    public models.response.User userPatch(String data, int id){
        return patch("/users/%s".formatted(id), data).
                as(models.response.User.class);
    }

    public void userDelete(int id){
        delete("/users/%s".formatted(id));
    }

    public void userDelete(models.response.User user) {
        userDelete(user.getId());
    }
}
