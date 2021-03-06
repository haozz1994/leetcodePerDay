package com.haozz.leetcode.leetcode202104.leetcode20210412;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * leetcode 705: 设计哈希集合
 * https://leetcode-cn.com/problems/design-hashset/
 *
 * @author haozhezhe@yunquna.com
 * @date 11:28 PM 4/12/21
 */
public class MyHashSet {

    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];


        // 这个地方，data已经初始化为一个长度为769的空数组，里面每个元素都是null
        // 如果用加强for循环，因为每个元素都是null，所以无法赋值，循环完成后每个元素还是null
        // 相当于在循环中给每个null做操作，做不了
        for (LinkedList datum : data) {
            datum = new LinkedList<Integer>();

            // 但是很奇怪，这里打印datum不是null，而是一个空的LinkedList
            // 但是断点看 data ， 还是all element is null
            System.out.println(datum);
        }

        // 这样写才可以
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<Integer>();
        }

        // 是不是说 ，所有数组都不能这样循环赋值，其实可以想想数组的内存结构，应该比较好理解
        // 第一步  data = new LinkedList[BASE]  只是开辟了一块长度是BASE的内存空间，并没有给每个元素赋值
        // 循环的时候，如果不用下标是获取不到每个元素的，也就不能赋值

    }

    private int hash(int key) {
        return key % BASE;
    }

    /**
     * 新增
     *
     * @param key
     */
    public void add(int key) {
        int hash = hash(key);
        Iterator iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            if ((Integer) iterator.next() == key) {
                return;
            }
        }
        data[hash].addLast(key);
    }

    /**
     * 移除
     *
     * @param key
     */
    public void remove(int key) {
        int hash = hash(key);
        Iterator iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            if ((Integer) iterator.next() == key) {
                iterator.remove();
                return;
            }
        }
    }

    /**
     * 是否包含
     *
     * @param key
     * @return
     */
    public boolean contains(int key) {
        int hash = hash(key);
        Iterator iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            if ((Integer) iterator.next() == key) {
                return true;
            }
        }
        return false;
    }
}
