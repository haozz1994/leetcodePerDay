package com.haozz.leetcode.leetcode202103.leetcode20210330;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *  
 *
 * 提示：
 *
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * @author haozhezhe@yunquna.com
 * @date 5:10 PM 3/30/21
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        // 定义结果
        int result = 0;
        // 定义中间值
        int temp = 0;

        // 遍历数据
        for (int num : nums) {
            // 如果当前值是0
            if (num == 0) {
                // 如果中间值大于结果值，将中间值覆给结果值
                if (temp > result) {
                    result = temp;
                }
                // 将中间值归零
                temp = 0;
            } else {
                // 如果当前值是1，中间值加1
                temp++;
            }
        }
        // 做兜底
        if (temp > result) {
            result = temp;
        }
        System.out.println(result);
        return result;
    }
}
