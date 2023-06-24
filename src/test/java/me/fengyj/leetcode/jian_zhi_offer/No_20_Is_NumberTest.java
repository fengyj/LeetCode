package me.fengyj.leetcode.jian_zhi_offer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class No_20_Is_NumberTest {
    
    @Test
    public void test_isNumber_1() {

        boolean actual = No_20_Is_Number.isNumber("1.23");

        assertTrue(actual);
    }
}
