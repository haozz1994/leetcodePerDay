package com.haozz.leetcode.leetcode202006.leetcode20200604;


/**
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 *
 * leetcode:构建乘积数组
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class Solution {


    /**
     * 这个解法  在leetcode上  执行时可以通过，但是在提交后，44个用例中第43个会执行失败，原因是超过时间限制
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a) {

        int b[]  = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] =   1;
            for (int j = 0; j < i; j++) {
                b[i] *= a[j];
            }
            for(int j = i+1; j<a.length;j++){
                b[i] *= a[j];
            }
        }

        return b;
    }

    public static void main(String[] args) {
        int [] b= constructArr(new int[]{1, 2, 3, 4, 5});

        for (int i : b) {
            System.out.println(i);
        }
    }


}
