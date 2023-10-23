package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;

public class No_518_CoinChangeII {
    public int change(int amount, int[] coins) {

        int[] cache = new int[amount + 1];
        Arrays.fill(cache, 0);
        cache[0] = 1;

        for(int c = 0; c < coins.length; c++) {
            int v = coins[c];
            for(int a = v; a <= amount; a++) {

                cache[a] = cache[a - v] + cache[a];
            }
        }
        return cache[amount];
    }
}
