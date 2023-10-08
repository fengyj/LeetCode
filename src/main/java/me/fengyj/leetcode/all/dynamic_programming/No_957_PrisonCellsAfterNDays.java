package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;

public class No_957_PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {

        Pair[] map = new Pair[2 << cells.length];

        int v = fromArray(cells);

        for (int i = 0; i < n; i++) {

            Pair s = map[v];
            if (s == null) {
                map[v] = new Pair(nextState(v, cells.length), i);
                s = map[v];
                if(s.next == v) return toArray(s.next, cells.length);
                v = s.next;
            }
            else {

                int steps = i - s.calculatedTime;
                int remainSteps = (n - (i + 1 - 1)) % steps;
                int nv = v;
                for (int m = 0; m < remainSteps; m++)
                    nv = map[nv].next;
                return toArray(nv, cells.length);
            }
        }

        return toArray(v, cells.length);
    }

    private static int fromArray(int[] arr) {

        int v = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) v = v + (2 << (arr.length - i - 1));
        }
        return v;
    }

    private static int[] toArray(int v, int l) {

        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            int t = 2 << i;
            arr[l - i - 1] = (v & t) == t ? 1 : 0;
        }
        return arr;
    }

    private static int nextState(int v, int l) {

        int s = 0;
        for (int i = 1; i < l - 1; i++) {

            int rv = (v & (2 << (i - 1))) << 2;
            int lv = v & (2 << (i + 1));
            if (rv == lv) s = s | (2 << i);
        }
        return s;
    }

    static class Pair {

        private int next;
        private int calculatedTime;

        public Pair(int next, int calculatedTime) {
            this.next = next;
            this.calculatedTime = calculatedTime;
        }
    }
}
