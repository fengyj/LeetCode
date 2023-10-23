package me.fengyj.leetcode.all.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class BagZeroOneTest {

    @Test
    public void test_maxValue() {

        int[] weights = new int[] {1, 3, 4};
        int[] values = new int[] {15, 20, 30};

        int actual = new BagZeroOne().maxValue(weights, values, 3);
        int expect = 20;

        Assert.assertEquals(expect, actual);

        actual = new BagZeroOne().maxValue(weights, values, 5);
        expect = 45;

        Assert.assertEquals(expect, actual);

        actual = new BagZeroOne().maxValue(weights, values, 6);
        expect = 45;

        Assert.assertEquals(expect, actual);

        actual = new BagZeroOne().maxValue(weights, values, 7);
        expect = 50;

        Assert.assertEquals(expect, actual);

        actual = new BagZeroOne().maxValue(weights, values, 8);
        expect = 65;

        Assert.assertEquals(expect, actual);

        actual = new BagZeroOne().maxValue(weights, values, 9);
        expect = 65;

        Assert.assertEquals(expect, actual);

        actual = new BagZeroOne().maxValue(weights, values, 0);
        expect = 0;

        Assert.assertEquals(expect, actual);

        actual = new BagZeroOne().maxValue(weights, values, 1);
        expect = 15;

        Assert.assertEquals(expect, actual);
    }
}
