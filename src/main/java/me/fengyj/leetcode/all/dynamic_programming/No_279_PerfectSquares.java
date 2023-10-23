package me.fengyj.leetcode.all.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_279_PerfectSquares {
    public int numSquares(int n) {

        int[] cache = new int[n + 1];
        for(int i = 0; i <= n; i++) cache[i] = i;

        int r = 2;
        while (true){
            int s = (int)Math.pow(r++, 2);
            if(s > n) break;
            for (int i = s; i <= n; i++) {

                cache[i] = Math.min(cache[i], cache[i - s] + 1);
            }
        }

        return cache[n];
    }
}
