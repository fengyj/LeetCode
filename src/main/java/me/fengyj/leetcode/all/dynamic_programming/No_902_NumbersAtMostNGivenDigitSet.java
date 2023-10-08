package me.fengyj.leetcode.all.dynamic_programming;

public class No_902_NumbersAtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] digits, int n) {

        int[] d = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            d[i] = Integer.parseInt(digits[i]);
        }
        int len = 1;
        int m = n;
        while (m >= 10) {
            len++;
            m = m / 10;
        }

        int count = 0;
        for(int i = 1; i < len; i++) count = count + (int)(Math.pow(d.length, i));

        for(int l = len; l >= 1; l--) {

            int num = n % (int)(Math.pow(10, l)) / (int)(Math.pow(10, l - 1));

            int cp = (int)(Math.pow(d.length, l - 1));
            int idx = -1;
            int c = 0;

            for(int i = 0; i < d.length; i++) {
                if(d[i] < num) {
                    c++;
                }
                else if(d[i] == num) {
                    idx = i;
                }
                else {
                    break;
                }
            }
            count += c * cp;
            if(idx == -1) break;
            else if(l == 1) count++;
        }

        return count;
    }
}
