package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;

public class No_583_DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {

        int minLen = Math.min(word1.length(), word2.length());
        String w1 = word1.length() == minLen ? word1 : word2;
        String w2 = word1.length() == minLen ? word2 : word1;
        int[][] cache = new int[minLen][w2.length() > 1 ? 2 : w2.length()];

        for(int i2 = 0; i2 < w2.length(); i2++) {
            for(int i1 = 0; i1 < w1.length(); i1++) {

                int c = w1.charAt(i1) == w2.charAt(i2) ? 1 : 0;
                if(c == 1) c += i1 > 0 && i2 > 0 ? cache[i1 - 1][0] : 0;

                c = Math.max(c, i2 > 0 ? cache[i1][0] : 0);
                c = Math.max(c, i1 > 0 ? cache[i1 - 1][i2 > 0 ? 1 : 0] : 0);

                cache[i1][i2 > 0 ? 1 : 0] = c;
            }
            if(i2 == 0) continue;
            for(int i1 = 0; i1 < w1.length(); i1++) {
                cache[i1][0] = cache[i1][1];
            }
        }
        int c = cache[cache.length - 1][cache[cache.length - 1].length - 1];
        return (w1.length() - c) + (w2.length() - c);
    }
}
