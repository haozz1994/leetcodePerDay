package com.haozz.leetcode.leetcode202006.leetcode20200602;

import java.util.TreeMap;

/**
 * 方法二：平衡树
 * 如果我们按时间顺序维护日程安排，则可以通过二分查找日程安排的情况来检查新日常安排是否可以预订，时间复杂度为 O(\log N)O(logN) （其中 NN 是已预订的日常安排数），若可以预定则我们还需要在排序结构中插入日常安排。
 * <p>
 * 算法：
 * <p>
 * 我们需要一个数据结构能够保持元素排序和支持快速插入。在 java 中，TreeMap 是最适合的。在 python 中，我们可以构建自己的二叉树结构。
 */
public class MyCalendarTreeMap {
    TreeMap<Integer, Integer> calendar;

    MyCalendarTreeMap() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度 (Java)：O(N \log N)O(NlogN)。其中 NN 是预订的日程安排数。对于每个新日程安排，我们用 O(\log N)O(logN) 的时间搜索该日程安排是否合法，若合法则将其插入日常安排中需要 O(1)O(1) 的时间。
     * 时间复杂度 (Python)：最坏的情况 O(N^2)O(N
     * 2
     *  )，其他情况是 O(N \log N)O(NlogN)。对于每个新日程安排，若新日程安排合法则将新日程安排插入到二叉树中。由于此树可能不平衡，因此可能需要线性步骤来遍历每个日常安排。
     * 空间复杂度：O(N)O(N)，数据结构所使用的空间。
     *
     */
}

