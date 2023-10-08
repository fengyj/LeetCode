package me.fengyj.algorithms.sorter;

/*
 * For a random order array, its performance is better than Insection. The bigger size the better performance.
 */
public class Shell<T extends Comparable<T>>  extends Sorter<T> {

    protected void sort_array(T[] a) {

        int h = 1;
        while (h < a.length / 3)
            h = h * 3 + 1;
            
        while (h >= 1) {

            for (int i = h; i < a.length; i++) {

                for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h) {
                    exch(a, j, j - h, 0, a.length - 1);
                }
            }
            h = h / 3;
        }
    }
}
