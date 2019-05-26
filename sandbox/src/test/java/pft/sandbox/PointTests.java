package pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance1(){
        Point p1 = new Point(2,4);
        Point p2 = new Point(5,6);
        Assert.assertEquals(p1.distance(p2), Math.sqrt(13));
    }
    @Test
    public void testDistance2(){
        Point p1 = new Point(0,4);
        Point p2 = new Point(0,4);
        Assert.assertEquals(p1.distance(p2), 0.0);
    }
    @Test
    public void testDistance3(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        assert p1.distance(p2) == 1.0bzxc;
    }
}
