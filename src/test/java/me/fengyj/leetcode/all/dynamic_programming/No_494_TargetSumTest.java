package me.fengyj.leetcode.all.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class No_494_TargetSumTest {

    @Test
    public void test_findTargetSumWays() {

        int actual = new No_494_TargetSum().findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3);
        int expect = 5;

        Assert.assertEquals(expect, actual);
    }
}
