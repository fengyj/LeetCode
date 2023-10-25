package me.fengyj.leetcode.all.dynamic_programming;

public class No_516_LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;

        int[][] cache = new int[s.length()][];
        for(int i = 0; i < cache.length; i++) {
            cache[i] = new int[i + 1];
            cache[i][i] = 1;
        }

        for(int j = 1; j < s.length(); j++) {

            for(int i = 0; i < s.length(); i++) {

                if(j > i) continue;
                int p = i - j;
                boolean equal = s.charAt(i) == s.charAt(p);
                if(j == 1) {
                    if(equal) {
                        cache[i][p] = 2;
                    }
                    else {
                        cache[i][p] = 1;
                    }
                }
                else{

                    int innerI = i - 1;
                    int innerP = p + 1;
                    if(equal) {
                        cache[i][p] = cache[innerI][innerP] + 2;
                    }
                    else {
                        cache[i][p] = Math.max(cache[i][innerP], cache[innerI][p]);
                    }
                }

            }
        }

        return cache[cache.length - 1][0];
    }
}
