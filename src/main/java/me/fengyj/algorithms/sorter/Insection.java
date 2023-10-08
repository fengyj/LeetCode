package me.fengyj.algorithms.sorter;

/*
 * O: N^2 / 4 (compare) & N^2 / 4 (exchange).
 * best O: N (compare) & 0 (exchange).
 * wrost O: N^2 / 2 (compare) & N^2 / 2 (exchange).
 */
public class Insection<T extends Comparable<T>> extends Sorter<T>{
    
    protected void sort_array(T[] a) {

        for(int i = 1; i < a.length; i++) {

            for(int j = i; j >= 1 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1, 0, a.length - 1);
            }
        }
    }
}
