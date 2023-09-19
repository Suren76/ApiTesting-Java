import com.github.javafaker.Faker;
import models.BaseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import models.request.User;
import services.ReqresIn;

import java.util.List;

public class ApiTests extends BaseTest {
    @Test(groups = {"postTest"})
    void testAddUser() {
        ReqresIn reqresIn = new ReqresIn();
        User userToAdd = new User(reqresIn.userPost());

        reqresIn.userPost(userToAdd);

        List<models.response.User> users = reqresIn.userGet();

        System.out.println(users);

        Assert.assertTrue(users.contains(new models.response.User(0,userToAdd.getName(),userToAdd.getGender(),userToAdd.getStatus(),userToAdd.getEmail())));

    }
}
