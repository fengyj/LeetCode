package me.fengyj.leetcode.all.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class No_188_BestTimeToBuyAndSellStockIVTest {

    @Test
    public void test_maxProfit(){

        int actual = new No_188_BestTimeToBuyAndSellStockIV().maxProfit(2, new int[] {6,1,3,2,4,7});
        int expect = 7;

        Assert.assertEquals(expect, actual);
    }
}
