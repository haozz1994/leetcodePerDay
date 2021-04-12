package com.haozz.leetcode.leetcode202104.leetcode20210412;

/**
 * @author haozhezhe@yunquna.com
 * @date 11:47 PM 4/12/21
 */
public class Ttt {

    public static void main(String[] args) {


        MyHashSet h = new MyHashSet();

        h.add(1);
        h.add(2);
        System.out.println(h.contains(3));
        h.remove(3);


        System.out.println(h);
    }
}
