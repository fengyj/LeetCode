
package me.fengyj.leetcode.jian_zhi_offer;

import java.util.*;

class No_05_Replace_Space {

    public String replaceSpace_1(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ')
                res.append("%20");
            else
                res.append(c);
        }
        return res.toString();
    }

    public String replaceSpace_2(String s) {

        if (s == null) return null;
        List<String> list = new ArrayList<>();
        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (endIdx >= startIdx)
                    list.add(s.substring(startIdx, endIdx));
                list.add("%20");
                startIdx = i + 1;
            } else {
                endIdx = i + 1;
            }
        }
        if (endIdx >= startIdx) list.add(s.substring(startIdx, endIdx));
        return String.join("", list);
    }

    public String replaceSpace_3(String s) {

        if (s == null) return null;
        return s.replace(" ", "%20");
    }
}