import com.github.javafaker.Faker;
import com.sun.net.httpserver.Request;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import request.User;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiTests extends BaseTest {
    @Test
    void testAddUser() {
        ReqresIn reqresIn = new ReqresIn();
        User userToAdd = new request.User(
                "smbulic76000",
                "male",
                "active",
                new Faker().internet().emailAddress()
        );

        reqresIn.userPost(userToAdd);

        List<response.User> users = reqresIn.userGet();

        System.out.println(users);

        Assert.assertTrue(users.contains(new response.User(0,userToAdd.getName(),userToAdd.getGender(),userToAdd.getStatus(),userToAdd.getEmail())));

    }
}
