package me.fengyj.leetcode.all.mono_stack;

import org.junit.Assert;
import org.junit.Test;

public class No_42_TrappingRainWaterTest {

    @Test
    public void test_trap(){

        int actual = new No_42_TrappingRainWater().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        int expect = 6;

        Assert.assertEquals(expect, actual);
    }
}
