package me.fengyj.leetcode.all.dynamic_programming;

public class No_647_PalindromicSubstrings {
    public int countSubstrings(String s) {

        boolean[][] cache = new boolean[s.length()][];

        for(int i = 0; i < s.length(); i++) {
            cache[i] = new boolean[i];
        }

        int count = s.length();
        for(int j = 1; j < s.length(); j++) {

            for(int i = 0; i < s.length(); i++) {

                if(j > i) continue;
                int p = i - j;
                int innerI = i - 1;
                int innerP = p + 1;
                boolean inner = j == 1 || innerI == innerP || cache[innerI][innerP];
                if(inner && (s.charAt(i) == s.charAt(p))) {
                    cache[i][p] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
