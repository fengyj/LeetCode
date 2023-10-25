package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;

public class No_115_DistinctSubsequences {

    public int numDistinct(String s, String t) {

        int[] prev = new int[s.length()];
        int[] curr = new int[s.length()];

        Arrays.fill(prev, 1);

        for(int ti = 0; ti < t.length(); ti++) {

            int ct = t.charAt(ti);
            for(int si = ti; si < s.length(); si++) {

                curr[si] = si == 0 ? 0 : curr[si - 1];
                if(s.charAt(si) == ct) {
                    curr[si] += si == 0 ? 1 : prev[si - 1];
                }
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
            Arrays.fill(curr, 0);
        }
        return prev[s.length() - 1];
    }
}
