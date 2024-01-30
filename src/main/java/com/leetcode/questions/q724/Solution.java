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
            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int ret = new Solution().pivotIndex(nums);
        System.out.println(ret);
    }
}