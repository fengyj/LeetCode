package me.fengyj.leetcode.all.mono_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class No_503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];

        if(nums.length == 0) return result;
        Arrays.fill(result, -1);

        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < result.length * 2; i++) {

            if(stack.isEmpty() && i >= result.length) break;

            int idx = i % result.length;

            int n = nums[idx];

            while (!stack.isEmpty() && nums[stack.peek()] < n) {
                result[stack.pop()] = n;
            }
            if(i < result.length)
                stack.push(i);
        }

        return result;
    }
}
