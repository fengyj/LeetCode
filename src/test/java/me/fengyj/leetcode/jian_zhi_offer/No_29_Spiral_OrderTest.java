package me.fengyj.leetcode.jian_zhi_offer;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class No_29_Spiral_OrderTest {
    
    @Test
    public void test_spiralOrder() {

        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};

        int[] expected = new int[] {1, 2, 3, 6, 9, 8, 7, 4, 5};
        int[] actual = new No_29_Spiral_Order().spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }
}
