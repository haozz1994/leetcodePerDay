package com.haozz.leetcode.leetcode202201.leetcode20220116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *  
 *
 * 注意：
 *
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 *
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 *  
 *
 * 提示：
 *
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 *  
 *
 * 进阶：你能否仅用一个队列来实现栈。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author haozhezhe@yunquna.com
 * @date 10:51 PM 1/16/22
 */
public class Solution {

    /**
     * 用两个队列实现一个栈
     *
     * 解题思路：
     * 1.准备两个队列，Q1、Q2，Q1是主队列，也就是当栈用的队列，Q2是操作辅助队列
     *
     * 2.【入栈】操作步骤如下：
     *      2.1：将元素入队到Q2
     *      2.2：将Q1中的所有元素依次出队并入队到Q2
     *      2.3：将Q1和Q2互换（其实也就是把Q2的所有元素出队然后入队到Q1）
     * 3.【移除并返回栈顶元素】：
     *      3.1：将主队列Q1的首元素出队并返回
     * 4.【返回栈顶元素】：
     *      4.1：将主队列Q1的首元素返回
     * 5.【判断栈为空】：
     *      5.1：判断主队列Q1是否为空
     *
     */


    /**
     *                                      栈                 队列
     * 入队/入栈                            push                offer
     * 移除并返回栈顶/队首元素                pop                 poll
     * 返回栈顶/队首元素（不移除）            top                 peek
     *
     */


    class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;


        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q2.offer(x);
            while(!q1.isEmpty()){
                q2.offer(q1.poll());
            }
            Queue temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
