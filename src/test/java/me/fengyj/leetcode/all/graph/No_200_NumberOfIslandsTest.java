package me.fengyj.leetcode.all.graph;

import org.junit.Assert;
import org.junit.Test;

public class No_200_NumberOfIslandsTest {

    @Test
    public void test_numIslands() {

        int actual = new No_200_NumberOfIslands().numIslands(new char[][] {
                {'1','1','1','1','0'}, 
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        });
        int expect = 1;

        Assert.assertEquals(expect, actual);
    }
}
