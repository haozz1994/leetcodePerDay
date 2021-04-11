package com.haozz.leetcode.leetcode202104.leetcode20210411;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 217
 *
 * 数组 哈希表
 *
 *
 * //给定一个整数数组，判断是否存在重复元素。
 * //
 * // 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: [1,2,3,1]
 * //输出: true
 * //
 * // 示例 2:
 * //
 * //
 * //输入: [1,2,3,4]
 * //输出: false
 * //
 * // 示例 3:
 * //
 * //
 * //输入: [1,1,1,3,3,4,3,2,4,2]
 * //输出: true
 * // Related Topics 数组 哈希表
 * // 👍 379 👎 0
 * @author haozhezhe@yunquna.com
 * @date 11:44 PM 4/11/21
 */
public class Solution {

    /**
     * 傻瓜穷举法，在leetcode提交时，因为case数组太长会timeout
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j] && i!=j){
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 官方解法，排序
     * 排序后，如果有相邻的元素相等，返回true
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 官方解法，hash表
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;

    }
}