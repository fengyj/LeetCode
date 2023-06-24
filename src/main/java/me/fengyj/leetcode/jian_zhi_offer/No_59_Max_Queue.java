package me.fengyj.leetcode.jian_zhi_offer;

import java.util.LinkedList;
import java.util.List;

public class No_59_Max_Queue {
    
    private LinkedList<Integer> queue = new LinkedList<>();
    private LinkedList<Integer> maxValues = new LinkedList<>();

    public No_59_Max_Queue() {
        queue.clear();
        maxValues.clear();
    }
    
    public int max_value() {

        if(maxValues.isEmpty()) return -1;
        return maxValues.getFirst();
    }
    
    public void push_back(int value) {

        while(!maxValues.isEmpty() && maxValues.peekLast() < value) {
            maxValues.pollLast();
        }
        maxValues.add(value);
        queue.add(value);
    }
    
    public int pop_front() {

        if(queue.isEmpty()) return -1;
        var val = queue.pop();

        if(maxValues.peekFirst().equals(val))
            maxValues.pop();
        return val;
    }
}
