package me.fengyj.leetcode.jian_zhi_offer;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class No_50_Max_Value_In_WindowTest {
    
    @Test
    public void test_maxSlidingWindow_1() {

        int[] nums = new int[] {1, 3, -1, 3, 5, 5, 3, 6, 7};
        int k = 3;

        int[] expected = new int[] {3, 3, 5, 5, 5, 6, 7};
        int[] actual = new No_50_Max_Value_In_Window().maxSlidingWindow_1(nums, k);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_maxSlidingWindow_2() {

        int[] nums = new int[] {1, 3, -1, 3, 5, 5, 3, 6, 7};
        int k = 3;

        int[] expected = new int[] {3, 3, 5, 5, 5, 6, 7};
        int[] actual = new No_50_Max_Value_In_Window().maxSlidingWindow_2(nums, k);

        assertArrayEquals(expected, actual);
    }
}
