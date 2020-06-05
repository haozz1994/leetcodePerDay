package com.haozz.leetcode.leetcode202006.leetcode20200605;

/**
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * <p>
 * leetcode:747.至少是其他数字两倍的最大数
 * <p>
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *  
 * <p>
 * 提示:
 * <p>
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
 */
public class Solution {

    /**
     * 暴力穷举法
     * <p>
     * 官方解释：线性扫描
     * <p>
     * 算法：
     * <p>
     * 扫描数组找到唯一的最大元素 m，并记录它的索引 maxIndex。
     * 再次扫描数组，如果我们找到 x != m，m < 2*x，我们应该返回 -1。
     * 否则返回 maxIndex
     * PythonJava
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N)O(N)。NN 指的是 nums 的大小
     * 空间复杂度：O(1)O(1)，只用了常数空间。
     *
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i] * 2 && i != maxIndex) {
                return -1;
            }
        }

        return maxIndex;
    }

    /**
     * 官网上有一个用最大值和第二大值的方法，很巧妙
     *
     * 设置 one、two 表示最大值和第二大值的数字；
     * 设置 oneIndex 表示最大值的索引；
     * 通过 for 遍历 nums；
     * 遍历 nums 过程中：如果这个数 nums[i] 比最大值还大，那么替换掉 two、one、oneIndex；如果这个数 nums[i] 比第二大值还大，那么替换掉第二大值 two。
     * 判断 one 是否大于或者等于 two * 2，返回 oneIndex 或者 -1。
     */
    public int domiantIndex(int nums[]) {
        int max = 0;
        int secondMax = 0;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max > secondMax << 2 ? maxIndex : -1;
    }


    public static void main(String[] args) {

        System.out.println(dominantIndex(new int[]{0, 0, 0, 1}));
    }
}
