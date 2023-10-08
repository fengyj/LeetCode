package me.fengyj.huawei_od;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringEncryptor {

    public static String encrypt(String input) {

        if(input == null) return null;

        OffsetCalculator calc = new OffsetCalculator(input.length());
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            chars[i] = encrypt(chars[i], calc.getOffset(i));
        }
        return String.copyValueOf(chars);
    }

    private static char encrypt(char c, int offset) {

        int n = (int)c;
        n = n + (offset % 26);
        if(n > 'z') n = n - 26;

        return (char)n;
    }

    public static class OffsetCalculator {

        private final List<Integer> offsets = new ArrayList<>();

        public OffsetCalculator(int length) {

            LinkedList<Integer> last3 = new LinkedList<>();
            if(length >= 1) {
                offsets.add(1);
                last3.add(1);
            }
            if(length >= 2) {
                offsets.add(2);
                last3.add(2);
            }
            if(length >= 3) {
                offsets.add(4);
                last3.add(4);
            }
            for(int i = 4; i <= length; i++) {

                int v = last3.stream().reduce(0, Integer::sum);
                offsets.add(v);
                last3.pollFirst();
                last3.push(v);
            }
        }

        public int getOffset(int idx) {

            if(idx < 0 || idx >= offsets.size()) return -1;

            return offsets.get(idx);
        }
    }
}
