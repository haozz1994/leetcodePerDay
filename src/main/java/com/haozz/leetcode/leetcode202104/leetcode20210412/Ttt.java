package com.haozz.leetcode.leetcode202104.leetcode20210412;

/**
 * @author haozhezhe@yunquna.com
 * @date 11:47 PM 4/12/21
 */
public class Ttt {

    public static void main(String[] args) {


//        MyHashSet h = new MyHashSet();
//
//        h.add(1);
//        h.add(2);
//        System.out.println(h.contains(3));
//        h.remove(3);
//
//
//        System.out.println(h);


        // 验证空数组是否只能使用fori循环为每个元素赋值，不能使用增强for循环

        Student[] s = new Student[100];

        for (Student student : s) {
            student = new Student("bo", 1);
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = new Student("bo", 1);
        }

        // 果然如此
        // https://blog.csdn.net/weixin_43244698/article/details/89428723
        // 总结：增强for循环的变量只是一个临时变量，并不是数组中的真实元素
        // 赋值时，只是改变了临时变量的值，并不会改变数组元素的值
        // 所以增强for循环只适用于数据读取，不会对原集合或者数组产生改变


    }
}
