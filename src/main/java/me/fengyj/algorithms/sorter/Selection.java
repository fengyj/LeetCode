package me.fengyj.algorithms.sorter;

/*
 * O: N^2 / 2 (compare) & N (exchange)
 */
public class Selection<T extends Comparable<T>> extends Sorter<T>{

    protected void sort_array(T[] a) {

        for(int i = 0; i < a.length; i++) {

            int min = i;
            for(int j = i + 1; j < a.length; j++) {

                if(less(a[j], a[min])) min = j;
            }
            if(i != min)
                exch(a, i, min, 0, a.length - 1);
        }
    }

}