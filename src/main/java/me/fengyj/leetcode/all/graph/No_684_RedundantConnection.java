package me.fengyj.leetcode.all.graph;

public class No_684_RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        int[] parents = initParents(edges.length + 1);

        int[] result = null;
        for(int[] e : edges) {

            if(isSameRoot(e[0], e[1], parents)) result = e;
            join(e[0], e[1], parents);
        }

        return result;
    }

    private int[] initParents(int n) {

        int[] parents = new int[n];
        for(int i = 0; i < n; i++) parents[i] = i;
        return parents;
    }

    private boolean isSameRoot(int x, int y, int[] parents) {
        x = findRoot(x, parents);
        y = findRoot(y, parents);

        return x == y;
    }

    private int findRoot(int v, int[] parents) {
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    private void findAndUpdateRoot(int v, int[] parents, int root) {
        while (v != parents[v] && v != root) {
            int r = parents[v];
            parents[v] = root;
            v = r;
        }
        parents[v] = root;
    }

    private void join(int x, int y, int[] parents) {
        findAndUpdateRoot(y, parents, findRoot(x, parents));
    }
}
