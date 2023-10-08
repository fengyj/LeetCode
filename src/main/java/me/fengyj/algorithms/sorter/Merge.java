package me.fengyj.algorithms.sorter;

import java.lang.reflect.Array;

/*
 * O: NlgN / 2 to NlgN (compare) & 6NlgN ()
 */
public class Merge<T extends Comparable<T>> extends Sorter<T> {
    
    private void merge(T[] a, int lo, int mid, int hi, T[] copy) {

        for(int k = lo; k <= hi; k++)
            copy[k] = a[k];

        for(int k = lo, i = lo, j = mid + 1; k <= hi; k++) {
            int c = k;
            if(i > mid) c = j++;
            else if(j > hi) c = i++;
            else if(less(copy[j], copy[i])) c = j++;
            else c = i++;
            a[k] = copy[c];

            stepNo++;
            exchangeTimes++;
            show(copy, -1, c, stepNo, lo, hi);
            show(a, k, -1, stepNo, lo, hi);
        }
    }

    protected void sort_array(T[] a) {

        if(a == null || a.length == 0) return;

        T[] copy = (T[])Array.newInstance(a[0].getClass(), a.length);
        for(int k = 0; k < a.length; k++) copy[k] = a[k];

        short_array(a, 0, a.length - 1, copy);
    }

    private void short_array(T[] a, int lo, int hi, T[] copy) {

        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        short_array(a, lo, mid, copy);
        short_array(a, mid + 1, hi, copy);
        merge(a, lo, mid, hi, copy);
    } 
}
