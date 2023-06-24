package me.fengyj.leetcode.jian_zhi_offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class No_50_Max_Value_In_Window {

    public int[] maxSlidingWindow_1(int[] nums, int k) {

        if (nums == null || k > nums.length)
            return null;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] maxValues = new int[nums.length - k + 1];
        for (int windowStart = 0; windowStart < maxValues.length; windowStart++) {

            boolean isInit = windowStart == 0;
            if (!isInit) {
                int idxOfMovingOut = windowStart - 1;
                if (map.lastEntry().getValue() == idxOfMovingOut)
                    map.remove(nums[idxOfMovingOut]);
            }
            int idxOfMovingIn = isInit ? windowStart : windowStart + k - 1;
            for (int i = idxOfMovingIn; i < windowStart + k; i++) {
                var v = nums[i];
                while (true) {
                    var key = map.floorKey(v);
                    if (key == null)
                        break;
                    map.remove(key);
                }
                map.put(v, i);
            }
            maxValues[windowStart] = map.lastKey();
        }
        return maxValues;
    }

    public int[] maxSlidingWindow_2(int[] nums, int k) {

        if (nums.length == 0 || k == 0)
            return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}
