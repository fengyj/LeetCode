package me.fengyj.leetcode.all.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class No_115_DistinctSubsequencesTest {

    @Test
    public void test_numDistinct() {

        int actual = new No_115_DistinctSubsequences().numDistinct("rabbbit", "rabit");
        int expect = 3;

        Assert.assertEquals(expect, actual);
    }
}
