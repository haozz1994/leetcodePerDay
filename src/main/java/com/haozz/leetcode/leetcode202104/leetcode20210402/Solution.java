package com.haozz.leetcode.leetcode202104.leetcode20210402;

/**
 * 栈
 * 496  下一个更大元素
 * https://leetcode-cn.com/problems/next-greater-element-i/
 *
 * @author haozhezhe@yunquna.com
 * @date 5:26 PM 4/2/21
 */
public class Solution {

    public static void main(String[] args) {
        int [] nums1 = {4,1,2};
        int [] nums2 = {1,3,4,2};
        for (int i : nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }
    }

    /**
     * 遍历法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            outer:
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    if (j == nums2.length - 1) {
                        result[i] = -1;
                    } else {
                        for (int k = j + 1; k < nums2.length; k++) {
                            if (nums2[k] > nums1[i]) {
                                result[i] = nums2[k];
                                break outer;
                            }
                        }
                        result[i] = -1;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 使用栈
     */
}
