package com.haozz.leetcode.leetcode202104.leetcode20210412;

import java.util.ArrayList;
import java.util.List;

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

        List<Student> list = new ArrayList<>();
        list.add(new Student("a",1));
        list.add(new Student("agg",1));
        list.add(new Student("fdfd",1));
        list.add(new Student("dd",1));
        list.add(new Student("b",1));

        for (Student student : list) {
            student = new Student("change", 99);
        }

        list.forEach(i -> System.out.println(i));
        // 这个地方也是一样，增强for循环中重新赋值，不会改变原集合的元素
        // 这里使用重新set是可以的，当然可以了，set相当于是改变原来的元素





        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        for (Integer integer : ll) {
            integer = 99;
        }

        ll.forEach(i -> System.out.println(i));
        // 这次增强for循环还是不生效，一样的道理

        // 可以这样理解，增强for循环中进行赋值操作，就是把集合或者数组中的每个元素，重新赋值给了一个新的局部变量
        // 这样当然是不会改变原有元素的


    }
}
