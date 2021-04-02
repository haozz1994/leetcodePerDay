package com.haozz.leetcode.leetcode202103.leetcode20210331;

/**
 * 27 移除元素 解法二
 *
 * @author haozhezhe@yunquna.com
 * @date 4:01 PM 3/31/21
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,3,4};
        removeElement(nums, 4);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return n;
    }
}
