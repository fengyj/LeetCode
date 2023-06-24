package me.fengyj.leetcode.jian_zhi_offer;

public class No_29_Spiral_Order {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null)
            return null;
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int lengthX = matrix[0].length;
        int lengthY = matrix.length;
        int[] result = new int[lengthX * lengthY];
        int r = 0;
        int x = 0;
        int y = 0;
        int stepX = 1;
        int stepY = 0;
        int startX = 0;
        int startY = 0;
        int endX = lengthX - 1;
        int endY = lengthY - 1;

        while (r < result.length) {

            result[r++] = matrix[y][x];
            if (x == startX && y == startY && stepY == -1) {
                stepX = 1;
                stepY = 0;
                startX++;
            } else if (x == endX && y == startY && stepX == 1) {
                stepX = 0;
                stepY = 1;
                startY++;
            } else if (x == endX && y == endY && stepY == 1) {
                stepX = -1;
                stepY = 0;
                endX--;
            } else if (x == startX && y == endY && stepX == -1) {
                stepX = 0;
                stepY = -1;
                endY--;
            }
            x = x + stepX;
            y = y + stepY;
        }

        return result;
    }
}