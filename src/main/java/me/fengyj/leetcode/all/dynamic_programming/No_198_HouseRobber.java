package me.fengyj.leetcode.all.dynamic_programming;

public class No_198_HouseRobber {
    public int rob(int[] nums) {

        int t1 = 0;
        int t2 = 0;
        int t3 = 0;

        for(int i = 0; i < nums.length; i++) {

            int t = Math.max(t2, t3) + nums[i];

            t3 = t2;
            t2 = t1;
            t1 = t;
        }
        return Math.max(t1, t2);
    }
}
