package me.fengyj.leetcode.jian_zhi_offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class No_67_String_To_IntTest {
    
    @Test
    public void test_strToInt() {

        var str = "  10  ";
        Integer actual = new No_67_String_To_Int().strToInt(str);
        Integer expected = 10;

        assertEquals(expected, actual);

        str = "-54324 sdfsa";
        actual = new No_67_String_To_Int().strToInt(str);
        expected = -54324;

        assertEquals(expected, actual);

        str = Integer.toString(Integer.MIN_VALUE);
        actual = new No_67_String_To_Int().strToInt(str);
        expected = Integer.MIN_VALUE;

        assertEquals(expected, actual);
    }
}
