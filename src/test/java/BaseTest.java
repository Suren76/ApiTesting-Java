import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeClass
    void setup() {
        ReqresIn.setup();
    }
}
