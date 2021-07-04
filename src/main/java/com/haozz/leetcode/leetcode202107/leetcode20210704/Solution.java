package com.haozz.leetcode.leetcode202107.leetcode20210704;

/**
 * leetcode 344  反转字符串 | Reverse String
 * <p>
 * https://leetcode-cn.com/problems/reverse-string/
 * <p>
 * //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * //
 * // 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * //
 * // 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：["h","e","l","l","o"]
 * //输出：["o","l","l","e","h"]
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：["H","a","n","n","a","h"]
 * //输出：["h","a","n","n","a","H"]
 * // Related Topics 双指针 字符串
 *
 * @author haozhezhe@yunquna.com
 * @date 7:09 PM 7/4/21
 */
public class Solution {


    /**
     * 双指针算法
     * 可以想一下，既然是要反转字符串，那就需要把字符串的第1位和倒数第1位、第2位和倒数第2位、第3位和倒数第3位进行交换...
     * 定义两个指针，一个在头一个在尾，进行互换，然后头指针向后移动一位，尾指针向前移动一位
     * 当两个指针相遇时，代表走到了字符串的中点，也就是已近翻转完成了
     */
    public void reverseString(char[] s) {
        int length = s.length;
        for (int left = 0, right = length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
