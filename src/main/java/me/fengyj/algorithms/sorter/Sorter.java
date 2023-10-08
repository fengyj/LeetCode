package me.fengyj.algorithms.sorter;

import java.time.Duration;
import java.time.Instant;

public abstract class Sorter<T extends Comparable<T>> {

    public static boolean SHOW_STEPS = false;
    protected int stepNo = 0;
    protected int compareTimes = 0;
    protected int exchangeTimes = 0;
    
    protected boolean less(T v, T w) {

        compareTimes++;
        return v.compareTo(w) < 0;
    }

    protected void exch(T[] a, int i, int j, int lo, int hi) {
        var t = a[i];
        a[i] = a[j];
        a[j] = t;
        stepNo++;
        exchangeTimes++;
        if(SHOW_STEPS) show(a, i, j, stepNo, lo, hi);
    }

    public static <T extends Comparable<T>> void show(T[] a) {

        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {

        for(int i = 1; i < a.length; i++)
        if(a[i - 1].compareTo(a[i]) > 0) return false;
        return true;
    }

    public void sort(T[] a) {
        
        if(SHOW_STEPS) {
            System.out.println(String.format("%s sort:", this.getClass().getSimpleName()));
            show(a, -1, -1, 0, 0, a.length - 1);
        }
        Instant start = Instant.now();
        sort_array(a);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(String.format("(%d ms elapsed, compared %d times, and exchanged %d times)", timeElapsed, compareTimes, exchangeTimes));
    }

    protected abstract void sort_array(T[] a);

    protected static <T extends Comparable<T>> void show(T[] a, int m, int n, int step, int lo, int hi) {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_WHITE = "\u001B[37m";

        System.out.print(ANSI_YELLOW + String.format("%1$3s:", step) + ANSI_RESET + "    ");
        for(int i = 0; i < a.length; i++) {
            String prev = i == m ? ANSI_RED : (i == n ? ANSI_GREEN : (i < lo  || i > hi ? ANSI_WHITE : ""));
            String post = i == m || i == n || i < lo  || i > hi ? ANSI_RESET : "";
            System.out.print(prev + a[i] + post + " ");
        }
        System.out.println();
    }
}
