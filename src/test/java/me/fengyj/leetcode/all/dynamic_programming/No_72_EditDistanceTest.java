package me.fengyj.leetcode.all.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class No_72_EditDistanceTest {

    @Test
    public void test_minDistance() {

        int actual = new No_72_EditDistance().minDistance("zoologicoarchaeologist", "zoogeologist");
        int expect = 10;

        Assert.assertEquals(expect, actual);
    }
}
