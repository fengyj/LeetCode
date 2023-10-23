package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class No_139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] cache = new boolean[s.length() + 1];
        Arrays.fill(cache, false);
        cache[0] = true;

        for(int i = 1; i <= cache.length; i++) {
            for(String w : wordDict) {
                if(w.length() > i) continue;
                if(!cache[i - w.length()]) continue;
                if(s.startsWith(w, i - w.length())) {
                    cache[i] = true;
                    break;
                }
            }
        }

        return cache[s.length()];
    }
}
