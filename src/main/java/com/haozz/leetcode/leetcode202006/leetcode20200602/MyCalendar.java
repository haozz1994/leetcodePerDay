package com.haozz.leetcode.leetcode202006.leetcode20200602;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/my-calendar-i/
 * <p>
 * leetcode: 729 我的日程安排表
 * <p>
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 * <p>
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * <p>
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 * <p>
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * <p>
 * 示例 1:
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * 解释:
 * 第一个日程安排可以添加到日历中.  第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了。
 * 第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20 。
 * 说明:
 * <p>
 * 每个测试用例，调用 MyCalendar.book 函数最多不超过 100次。
 * 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。
 */
public class MyCalendar {


    /**
     * 暴力穷举法
     * 复杂度分析
     *
     * 时间复杂度：O(N^2)O(N
     * 2
     *  )。NN 指的是日常安排的数量，对于每个新的日常安排，我们检查新的日常安排是否发生冲突来决定是否可以预订新的日常安排。所以时间复杂度为 \sum_k^N O(k) = O(N^2)∑
     * k
     * N
     * ​
     *  O(k)=O(N
     * 2
     *  )。
     * 空间复杂度：O(n)O(n)，calendar 所使用的空间大小。
     *
     */
    public MyCalendar() {
        list = new ArrayList<>();
    }

    public List<int[]> list;


    public boolean book(int start, int end) {

        for (int[] ints : list) {
            boolean valid = ints[0] >= end || ints[1]<=start;
            if (!valid){
                return false;

            }
        }

        list.add(new int[]{start, end});
        return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
