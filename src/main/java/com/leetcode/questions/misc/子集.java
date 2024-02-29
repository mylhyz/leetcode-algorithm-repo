package com.leetcode.questions.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//经典回溯
// 三板斧
// 1，确定方法的输入和输出
// 传入nums，另外需要有一个startIndex作为此次遍历的开始
// 另外使用result存放结果，path存放找到的路径
// 2，确定终止条件
// 此处实际上无需终止条件，或者当startIndex超过数组能够索引的范围即可
// 另外需要关注存放结果，一般是在终止条件阶段
// 这里的结果存放直接在方法开头即可
// 3，确定回溯代码
// 从 startIndex 开始，先向路径中添加一个数字，然后startIndex+1，回溯完成之后再恢复现场

public class 子集 {

    private static final List<List<Integer>> result = new ArrayList<>();
    private static final LinkedList<Integer> path = new LinkedList<>();

    public static void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; ++i) {
            path.push(nums[i]);
            backtracking(nums, i + 1);
            path.pop();
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        backtracking(nums, 0);
        System.out.println(result);
    }
}
