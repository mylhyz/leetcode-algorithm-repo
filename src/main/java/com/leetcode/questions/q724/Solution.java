package com.leetcode.questions.q724;

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            //计算总数
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i != 0) { // 一个条件是index=0时，认为左边的值是0
                leftSum += nums[i - 1];
            }
            int x = 0;
            if (i != nums.length - 1) {
                x = nums[i + 1];
            }
            int rightSum = sum - leftSum - x;
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}