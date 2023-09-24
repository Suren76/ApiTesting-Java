import org.testng.Assert;
import org.testng.annotations.Test;
import services.ReqresIn;

import java.util.List;

public class ApiTests extends BaseTest {
    @Test(groups = {"postTest"})
    void testAddUser() {
        ReqresIn reqresIn = new ReqresIn();
        var response = reqresIn.userPost();

        List<models.response.User> users = reqresIn.userGet();

        Assert.assertTrue(users.contains(response));
    }

    @Test(groups = {"postTest"})
    void testAddUserNegative() {

    }
}
