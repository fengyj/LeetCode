package me.fengyj.leetcode.jian_zhi_offer;

public class No_58_Left_Rotate_String {

    public String rotate_1(String s, int n) {
        
        if(n < 0 || n >= s.length()) return null;

        return s.substring(n) + s.substring(0, n);
    }
}