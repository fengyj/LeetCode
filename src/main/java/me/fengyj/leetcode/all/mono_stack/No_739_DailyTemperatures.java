package me.fengyj.leetcode.all.mono_stack;

import java.util.Stack;

public class No_739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures.length == 0) return new int[0];

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        int prev = temperatures[0];
        for(int i = 1; i < result.length; i++) {

            int n = temperatures[i];
            if(n > prev) {
                result[i - 1] = 1;
                while (!stack.isEmpty() && n > temperatures[stack.peek()]) {
                    int pi = stack.pop();
                    result[pi] = i - pi;
                }
            }
            else {
                stack.push(i - 1);
            }
            prev = n;
        }
//
//        while (!stack.isEmpty())
//            result[stack.pop()] = 0;
//
//        result[result.length - 1] = 0;

        return result;
    }
}
