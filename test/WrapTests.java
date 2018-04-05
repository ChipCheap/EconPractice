import application.model.Map;
import org.junit.*;

public class WrapTests {

    private Map m;

    @Before
    public void setUp(){
        m = new Map(30, 20);
    }

    @Test
    public void test(){
        assert(m.wrapCoordinates(32) == 2);
        assert(m.wrapCoordinates(-3) == 27);
        assert(m.wrapCoordinates(-31) == 29);
        assert(m.wrapCoordinates(15) == 15);
    }

    @After
    public void tearDown(){
        m = null;
    }
}
