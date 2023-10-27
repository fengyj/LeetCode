package me.fengyj.leetcode.all.mono_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class No_42_TrappingRainWater {
    public int trap(int[] height) {

        if(height.length <= 1) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;

        for(int i = 0; i < height.length; i++) {

            int h = height[i];
            int left = -1;
            while(!stack.isEmpty() && h >= height[stack.peek()]) {
                left = stack.pop();
            }
            if(stack.isEmpty() && left >= 0) {
                int minHeight = Math.min(h, height[left]);
                for(int j = left + 1; j < i; j++) {
                    sum += minHeight - height[j];
                }
            }
            if(h > 0) stack.push(i);
        }
        int right = stack.isEmpty() ? -1 : stack.pop();
        while (!stack.isEmpty()) {
            int left = stack.pop();
            for(int j = left + 1; j < right; j++)
                sum += height[right] - height[j];
            right = left;
        }

        return sum;
    }
}
