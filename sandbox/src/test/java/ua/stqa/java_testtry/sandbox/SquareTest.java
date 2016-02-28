package ua.stqa.java_testtry.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sikretSSD on 29.02.2016.
 */
public class SquareTest {

    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25.0);
    }
    @Test
    public void testPoint(){
        Point p1 = new Point(1, 2);
        Assert.assertEquals(p1.a, 1);
        Point p2 = new Point(3, 4);
        Assert.assertEquals(p2.b, 4);
    }
}
