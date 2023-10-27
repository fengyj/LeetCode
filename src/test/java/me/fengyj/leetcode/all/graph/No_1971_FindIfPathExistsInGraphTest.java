package me.fengyj.leetcode.all.graph;

import org.junit.Assert;
import org.junit.Test;

public class No_1971_FindIfPathExistsInGraphTest {

    @Test
    public void test_validPath() {

        boolean actual = new No_1971_FindIfPathExistsInGraph().validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
        boolean expect = true;

        Assert.assertEquals(expect, actual);
    }
}
