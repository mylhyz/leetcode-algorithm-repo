package com.leetcode.questions.q724;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//经典回溯
// 三板斧
// 1，确定方法的输入和输出
// 传入n和k，另外需要有一个startIndex作为此次遍历的开始
// 另外使用result存放结果，path存放找到的路径
// 2，确定终止条件
// 当path长度等于要求的长度后自然就可以返回了，此为终止
// 3，确定回溯代码
// 从 startIndex 开始，先向路径中添加一个数字，然后startIndex+1，回溯完成之后再恢复现场

public class 求组合总和II {

    private static final List<List<Integer>> result = new ArrayList<>();
    private static final LinkedList<Integer> path = new LinkedList<>();

    public static void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; ++i) {
            path.push(i);
            backtracking(n, k, i + 1);
            path.pop();
        }
    }


    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        backtracking(n, k, 1);
        System.out.println(result);
    }
}
