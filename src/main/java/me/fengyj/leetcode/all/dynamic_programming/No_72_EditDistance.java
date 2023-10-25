package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;

public class No_72_EditDistance {
    public int minDistance(String word1, String word2) {

        int[] prev = new int[word1.length() + 1];
        int[] curr = new int[word1.length() + 1];

        for(int i = 0; i < prev.length; i++) prev[i] = i;

        for(int i2 = 1; i2 <= word2.length(); i2++) {

            int c2 = word2.charAt(i2 - 1);
            curr[0] = i2;
            for(int i1 = 1; i1 < prev.length; i1++) {
                if(word1.charAt(i1 - 1) == c2) {
                    curr[i1] = prev[i1 - 1];
                }
                else {
                    int min = Math.min(Math.min(prev[i1 - 1], curr[i1 - 1]), prev[i1]);
                    curr[i1] = 1 + min;
                }
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
            Arrays.fill(curr, 0);
        }
        return prev[prev.length - 1];
    }
}
