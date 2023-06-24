package me.fengyj.leetcode.jian_zhi_offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class No_58_Left_Rotate_StringTest {
    
    @Test
    public void test_Rotate_1() {

        String actual = new No_58_Left_Rotate_String().rotate_1("abcdefg", 2);
        String expected = "cdefgab";

        assertEquals(expected, actual);
     }
}
