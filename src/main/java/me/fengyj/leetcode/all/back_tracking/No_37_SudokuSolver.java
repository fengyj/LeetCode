package me.fengyj.leetcode.all.back_tracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_37_SudokuSolver {

    public void solveSudoku(char[][] board) {

        Solver solver = new Solver(board);

        solver.tryFill(0, 0);
    }

    public static class Solver {

        private final int[][] contains = new int[9][9];
        private final char[][] board;

        public Solver(char[][] board) {

            this.board = board;

            for(int x = 0; x < board.length; x++) {
                for(int y = 0; y < board[x].length; y++) {
                    if (board[x][y] != '.') fill(x, y, board[x][y]);
                }
            }
        }

        public boolean tryFill(int x, int y) {

            int nextX = y == 8 ? x + 1 : x;
            int nextY = y == 8 ? 0 : y + 1;

            if(x > 8) return true;

            if(board[x][y] != '.') return tryFill(nextX, nextY);

            for(char c = '1'; c <= '9'; c++) {

                if(isCandidates(x, y, c)) {
                    fill(x, y, c);
                    if(tryFill(nextX, nextY)) return true;
                    unFill(x, y, c);
                }
            }

            return false;
        }

        public void fill(int x, int y, char v) {

            int ci = v - '1';
            set(x, y, v, true);

            board[x][y] = v;
        }

        public void unFill(int x, int y, char v) {

            int ci = v - '1';
            set(x, y, v, false);
            board[x][y] = '.';
        }

        private int getCharIndex(char c) {
            return c - '1';
        }

        private boolean containedInXAxis(int x, char v) {
            return (contains[x][getCharIndex(v)] & 1) == 1;
        }

        private boolean containedInYAxis(int y, char v) {
            return (contains[y][getCharIndex(v)] & 2) == 2;
        }

        private boolean containedInSubBoard(int x, int y, char v) {
            return (contains[calcSubBoardIndex(x, y)][getCharIndex(v)] & 4) == 4;
        }

        private void set(int x, int y, char v, boolean contained) {
            int si = calcSubBoardIndex(x, y);
            int ci = getCharIndex(v);
            contains[x][ci] = contained ? (contains[x][ci] | 1) : (contains[x][ci] ^ 1);
            contains[y][ci] = contained ? (contains[y][ci] | 2) : (contains[y][ci] ^ 2);
            contains[si][ci] = contained ? (contains[si][ci] | 4) : (contains[si][ci] ^ 4);
        }

        private boolean isCandidates(int x, int y, char v) {

            int ci = v - '1';
            return !(containedInXAxis(x, v) || containedInYAxis(y, v) || containedInSubBoard(x, y, v));
        }

        private int calcSubBoardIndex(int x, int y) {
            x = x / 3;
            y = y / 3;
            return x * 3 + y;
        }
    }

}
