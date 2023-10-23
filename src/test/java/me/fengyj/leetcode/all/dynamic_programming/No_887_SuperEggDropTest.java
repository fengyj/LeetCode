package me.fengyj.leetcode.all.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class No_887_SuperEggDropTest {

    @Test
    public void test_superEggDrop() {

        int actual = new No_887_SuperEggDrop().superEggDrop(100, 8192);
        int expect = 5;

        Assert.assertEquals(expect, actual);
    }
}
