package com.haozz.leetcode.leetcode202005.leetcode20200530;

import java.util.ArrayList;
import java.util.List;

/**
 * 还是孩子糖果问题
 * <p>
 * 上一个解法太复杂，需要遍历每一个元素，再和其他的元素挨个做比较
 * <p>
 * 相当于嵌套循环，时间复杂度n方
 */
public class Sulotion1 {


    /**
     * 这个解法不再是嵌套循环，而是两次循环
     * <p>
     * 首先将最大值找出来，然后在循环判断每一个元素和额外值相加后是否大于最大值
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = 0;
        for (int candy : candies) {
            if (candy >= max) {
                max = candy;
            }
        }

        List<Boolean> list = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }
}
