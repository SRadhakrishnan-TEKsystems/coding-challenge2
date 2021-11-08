package coding.challenge2;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AppTest {

    @Test(groups = {"smoke"})
    public void canaryTest() {
        assertEquals(true,true);
    }
}
