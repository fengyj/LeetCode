package me.fengyj.leetcode.jian_zhi_offer;

public class No_67_String_To_Int {

    public int strToInt(String s) {

        if (s == null)
            return 0;

        boolean started = false;
        int result = 0;
        boolean isNegative = false;

        int max_int_div_10 = Integer.MAX_VALUE / 10;
        int max_int_remain_10 = Integer.MAX_VALUE % 10;

        for (char c : s.toCharArray()) {

            if (c >= '0' && c <= '9') {
                started = true;
                int inc = c - '0';
                if (result > max_int_div_10) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                else if (result == max_int_div_10) {
                    if(isNegative && inc > max_int_remain_10) return Integer.MIN_VALUE;
                    else if(!isNegative && inc >= max_int_remain_10) return Integer.MAX_VALUE;
                }
                result = result * 10 + inc;
            } else if (started) {
                break;
            } else if(c == '-') {
                started = true;
                isNegative = true;
            } else if(c == '+') { 
                started = true;
                isNegative = false;
            } else if(started || c != ' ') {
                break;
            }
        }
        return isNegative ? result * -1 : result;
    }
}
