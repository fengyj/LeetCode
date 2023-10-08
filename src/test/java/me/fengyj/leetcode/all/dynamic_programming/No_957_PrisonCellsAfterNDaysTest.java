package me.fengyj.leetcode.all.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class No_957_PrisonCellsAfterNDaysTest {

    @Test
    public void test_prisonAfterNDays() {

        int[] cells = new int[] {0,1,0,1,1,0,0,1};

        int[] actual = new No_957_PrisonCellsAfterNDays().prisonAfterNDays(cells, 7);
        int[] expect = new int[] {0,0,1,1,0,0,0,0};

        Assert.assertArrayEquals(expect, actual);

        cells = new int[] {1,1,0,1,1,0,0,1};
        actual = new No_957_PrisonCellsAfterNDays().prisonAfterNDays(cells, 300663720);
        expect = new int[] {0,0,1,0,0,1,1,0};
        Assert.assertArrayEquals(expect, actual);


        cells = new int[] {1,0,0,0,1,0,0,1};
        actual = new No_957_PrisonCellsAfterNDays().prisonAfterNDays(cells, 99);
        expect = new int[] {0,0,1,0,1,0,0,0};
        Assert.assertArrayEquals(expect, actual);
    }
}
