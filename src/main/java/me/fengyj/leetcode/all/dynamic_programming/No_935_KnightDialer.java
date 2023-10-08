package me.fengyj.leetcode.all.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class No_935_KnightDialer {

    public int knightDialer(int n) {

        int[][] map = new int[10][];
        map[0] = new int[] {4,6};
        map[1] = new int[] {6, 8};
        map[2] = new int[] {7,9};
        map[3] = new int[] {4, 8};
        map[4] = new int[] {3, 9, 0};
        map[5] = new int[] {};
        map[6] = new int[] {1, 7, 0};
        map[7] = new int[] {2,6};
        map[8] = new int[] {1,3};
        map[9] = new int[] {2,4};

        int modNum = 1_000_000_007;

        int[] cache = new int[10];
        int[] current = new int[10];
        Arrays.fill(current, 1);

        for(int j = 1; j < n; j++) {

            int[] tmp = cache;
            cache = current;
            current = tmp;
            for(int i = 0; i < 10; i++) {

                int[] nexts = map[i];
                int c = 0;
                for(int m = 0; m < nexts.length; m++) {
                    c = (c + cache[nexts[m]]) % modNum;
                }
                current[i] = c;
            }
        }
        int c = 0;
        for(int i = 0; i < 10; i++) c = (c + current[i]) % modNum;

        return c;
    }
}
