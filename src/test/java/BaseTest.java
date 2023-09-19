import org.testng.annotations.BeforeClass;
import services.ReqresIn;

public class BaseTest {
    @BeforeClass
    void setup() {
        ReqresIn.setup();
    }
}
