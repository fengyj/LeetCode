package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;

public class No_494_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {

        int s = Arrays.stream(nums).sum();
        if(s < Math.abs(target)) return 0;
        int t = (s + target) / 2;
        if((s + target) != (t * 2)) return 0;

        int[] cache = new int[t + 1];

        cache[0] = 1;
        for(int i = 1; i <= t; i++) cache[i] = 0;

        for(int i = 1; i <= nums.length; i++) {

            int n = nums[i - 1];
            for(int b = t; b >= 0; b--) {

                if(n <= b) {
                    cache[b] = cache[b] + cache[b - n];
                }
            }
        }

        return cache[t];
    }
}
