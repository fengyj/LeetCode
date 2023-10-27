package me.fengyj.leetcode.all.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No_797_AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new LinkedList<>();
        find(graph, 0, result, new ArrayList<>());

        return result;
    }

    private void find(int[][] graph, int n, List<List<Integer>> result, List<Integer> path){

        path.add(n);

        if(n == graph.length - 1) {
            List<Integer> clone = new ArrayList<>(path);
            result.add(clone);
            return;
        }

        for(int i : graph[n]) {
            find(graph, i, result, path);
            path.remove(path.size() - 1);
        }
    }
}
