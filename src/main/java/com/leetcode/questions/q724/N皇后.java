package com.leetcode.questions.q724;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {

    private static final List<List<List<Character>>> result = new ArrayList<>();

    public static boolean isValid(List<List<Character>> chessboard, int row, int column, int n) {
        // 这个方式实际上蕴含了可以剪枝的操作，比如因为是按照行进行遍历的，所以超过当前行和列的部分都是没有必要遍历的
        // 比如可以直接检查当前行之前的行上有没有出现即可
        // 检查列
        for (int i = 0; i < n; ++i) {
            if (i == row) continue;
            if (chessboard.get(i).get(column) == 'Q') {
                return false;
            }
        }

        // 检查行
        for (int i = 0; i < n; ++i) {
            if (i == column) continue;
            if (chessboard.get(row).get(i) == 'Q') {
                return false;
            }
        }

        // 检查对角线
        for (int i = row, j = column; i > -1 && j > -1; --i, --j) {
            if (i == row && j == column) continue;
            if (chessboard.get(i).get(j) == 'Q') {
                return false;
            }
        }
        for (int i = row, j = column; i < n && j < n; ++i, ++j) {
            if (i == row && j == column) continue;
            if (chessboard.get(i).get(j) == 'Q') {
                return false;
            }
        }

        for (int i = row, j = column; i < n && j > -1; ++i, --j) {
            if (i == row && j == column) continue;
            if (chessboard.get(i).get(j) == 'Q') {
                return false;
            }
        }

        for (int i = row, j = column; i > -1 && j < n; --i, ++j) {
            if (i == row && j == column) continue;
            if (chessboard.get(i).get(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static List<List<Character>> Array2List(List<List<Character>> chessboard) {
        List<List<Character>> ret = new ArrayList<>();
        for (List<Character> l : chessboard) {
            ret.add(new ArrayList<>(l));
        }
        return ret;
    }

    public static void backtracking(int n, int row, List<List<Character>> chessboard) {
        if (n == row) {
            result.add(Array2List(chessboard));
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (isValid(chessboard, row, j, n)) {
                chessboard.get(row).set(j, 'Q');
                backtracking(n, row + 1, chessboard);
                chessboard.get(row).set(j, '.');
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        // row 是行
        // column 是列
        List<List<Character>> chessboard = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<Character> tmp = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                tmp.add('.');
            }
            chessboard.add(tmp);
        }
        backtracking(n, 0, chessboard);
        System.out.println(result);
    }
}
