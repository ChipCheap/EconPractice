import application.model.Ware;
import application.model.WareType;
import org.junit.*;

public class WareTests {

    private Ware ware;

    @Before
    public void setUp(){
        ware = new Ware(WareType.CANNONS, 30, 100);
    }

    @Test
    public void test(){
        assert(new Ware(WareType.CANNONS, 30, 40).equals(ware.split(40)));
        assert(new Ware(WareType.CANNONS, 32, 60).equals(ware));
    }

    @After
    public void tearDown(){
        ware = null;
    }

}
