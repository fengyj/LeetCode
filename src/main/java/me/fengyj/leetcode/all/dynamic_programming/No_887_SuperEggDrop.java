package me.fengyj.leetcode.all.dynamic_programming;

public class No_887_SuperEggDrop {

    public int superEggDrop2(int k, int n) {

        if (n == 1) {
            return 1;
        }
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= k; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][k] >= n) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    public int superEggDrop(int k, int n) {

        int[][] cache = new int[k + 1][n + 1];
        for(int i = 1; i <= n; i++) cache[1][i] = i;
        for(int i = 1; i <= k; i++) cache[i][1] = 1;

        for(int ki = 2; ki <= k; ki++) {
            boolean isSame = true;
            for(int ni = 2; ni <= n; ni++) {
                int c = Integer.MAX_VALUE;
                for(int m = ni / 2; m <= ni; m++) {
                    int d = m - 1;
                    int u = ni - m;
                    int t = Math.max(cache[ki - 1][d], cache[ki][u]);
                    if(t > c) break;
                    c = t;
                }
                for(int m = ni / 2 - 1; m >= 1; m--) {
                    int d = m - 1;
                    int u = ni - m;
                    int t = Math.max(cache[ki - 1][d], cache[ki][u]);
                    if(t > c) break;
                    c = t;
                }
                cache[ki][ni] = c + 1;
                isSame = isSame && cache[ki - 1][ni] == cache[ki][ni];
            }
            if(n < Math.pow(2, ki)) return cache[ki][n];
            if(isSame) return cache[ki][n];
        }

        return cache[k][n];
    }
}
