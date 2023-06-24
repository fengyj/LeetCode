package me.fengyj.leetcode.jian_zhi_offer;

import org.junit.*;

public class No_05_Replace_SpaceTest {
    
    @Test
    public void test_replaceSpace_1() {

        var obj = new No_05_Replace_Space();
        var result = obj.replaceSpace_1("We are happy.");
        var expect = "We%20are%20happy.";

        Assert.assertEquals(expect, result);
    }
}
