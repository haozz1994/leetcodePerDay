package com.haozz.leetcode.leetcode202006.leetcode20200601;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozhezhe@yunquna.com
 * @date 20:17 2020/6/1
 * <p>
 * https://leetcode-cn.com/problems/set-mismatch/
 * leetcode:645 错误的集合
 * <p>
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 * <p>
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 */
public class Solution {

//    public static int[] findErrorNums(int[] nums) {
//
//        int duplicate = 0;
//        int lost = 0;
//
//
//        int max = 0;
//
//        //找到nums中的最大值
////        for (int num : nums) {
////            if (num > max) {
////                max = num;
////            }
////        }
//
//        //这里其实是不用找最大值的，nums的长度就是最大值
//        max = nums.length;
//
//        //构造list
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= max; i++) {
//            list.add(i);
//        }
//
//        //遍历nums，在list中移除
//        for (int num : nums) {
//            //如果num不包含num，那么num就是丢失的那个
//            if (!list.contains(num)) {
//                lost = num;
//            } else {
//                //这里remove的是index，不是object，这就很恶心了
//                boolean remove = list.remove(new Integer(num));
//            }
//        }
//
//        //遍历nums移除完成之后，list中剩下的那个就是重复的
//        duplicate = list.get(0);
//
//
//        int[] result = {duplicate, lost};
//
//        return result;
//    }


    /**
     * map
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {

        int duplicate = 0;
        int lost = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.get(i) == null) {
                lost = i;
            } else if (map.get(i) == 2) {
                duplicate = i;
            }
        }

        return new int[]{duplicate, lost};


    }

    /**
     * 数组
     *
     * @param nums
     * @return
     */
    public static int[] finsErrorNums1(int[] nums) {

        int lost = 0;
        int duplicate = 0;
        int arr[] = new int[nums.length + 1];

        for (int num : nums) {
            arr[num] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                lost = i;
            } else if (arr[i] == 2) {
                duplicate = i;
            }
        }

        return new int []{duplicate, lost};
    }


    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 4};
        int[] errorNums = finsErrorNums1(nums);

        for (int errorNum : errorNums) {
            System.out.println(errorNum);
        }

    }


}
