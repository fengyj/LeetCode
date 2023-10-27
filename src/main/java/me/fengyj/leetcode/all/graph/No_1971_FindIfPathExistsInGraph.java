package me.fengyj.leetcode.all.graph;

public class No_1971_FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int[] parents = initParents(n);

        for(int[] e : edges) {
            join(e[0], e[1], parents);
        }
        return isSameRoot(source, destination, parents);
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
