package me.fengyj.leetcode.all.dynamic_programming;

public class No_96_UniqueBinarySearchTrees {

    public int numTrees(int n) {

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {

            int c = 0;
            for(int l = 1; l <= i; l++) {

                int lc = arr[l - 1];
                int rc = arr[i - l];
                c = c + lc * rc;
            }
            arr[i] = c;
        }
        return arr[n];
    }
}
