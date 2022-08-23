package ru.prnkstr.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance1() {
        Point p = new Point(5, 122, 5, 1);
        Assert.assertEquals(p.distance_test(), 121);
    }

    @Test
    public void testDistance2() {
        Point p = new Point(5, 5, 1, 1);
        Assert.assertEquals(p.distance_test(), 5.656854249492381);
    }
}
