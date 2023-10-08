package me.fengyj.algorithms.sorter;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> extends Sorter<T>{

    private T[] a = null;
    private int length = 0;

    public Heap() {

    }

    private void swim(int k) {

        while(k > 1 && less(a[k / 2], a[k])) {
            exch(a, k, k / 2, 1, length);
            k = k / 2;
        }
    }

    private void sink(int k) {

        int j = 2 * k;
        while(j <= length) {

            if(j < length && less(a[j], a[j + 1])) j++;
            if(!less(a[k], a[j])) break;
            exch(a, k, j, 1, length);
            k = j;
            j = 2 * k;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public void insert(T key) {

        if(key == null)
            throw new IllegalArgumentException("key cannot be null.");

        if(a == null) {
            a = (T[])Array.newInstance(key.getClass(), 16);
        }

        if(a.length == length + 1) {
            a = Arrays.copyOf(a, a.length * 2);
        }
        a[++length] = key;
        swim(length);
    }

    public T delMax() {

        if(a == null) return null;

        T max = (T)a[1];
        exch(a, 1, length, 1, length);
        length--;
        sink(1);
        return max;
    }

    @Override
    protected void sort_array(T[] a) {

        while (delMax() != null);

        for(T i : a) {
            insert(i);
        }

        for(int i = a.length - 1; i >=0; i--) {
            a[i] = delMax();
        }
    }
}
