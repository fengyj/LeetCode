package me.fengyj.algorithms.sorter;

import java.util.Arrays;

public class Quick<T extends Comparable<T>> extends Sorter<T> {

    protected void sort_array(T[] a) {

        sort_array(a, 0, a.length - 1);
    }

    private void sort_array(T[] a, int lo, int hi) {

        if (lo + 9 >= hi) {
            insection_sort(a, lo, hi);
            return;
        }

        T p = a[lo];
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            int c = a[i].compareTo(p);
            compareTimes++;
            if (c < 0)
                exch(a, lt++, i++, lo, hi);
            else if (c > 0)
                exch(a, i, gt--, lo, hi);
            else
                i++;
        }
        sort_array(a, lo, lt - 1);
        sort_array(a, gt + 1, hi);
    }

    private void insection_sort(T[] a, int lo, int hi) {
        
        for (int i = lo + 1; i < hi + 1; i++) {

            for (int j = i; j >= 1 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1, lo, hi);
            }
        }
    }
}
