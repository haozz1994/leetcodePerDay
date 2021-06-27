package com.haozz.leetcode.leetcode202106.leetcode20210626;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 141
 *
 * @author haozhezhe@yunquna.com
 * @date 7:14 PM 6/26/21
 */
//给定一个链表，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。
//
//
//
// 进阶：
//
// 你能用 O(1)（即，常量）内存解决此问题吗？
//
//
//
// 示例 1：
//
//
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 104]
// -105 <= Node.val <= 105
// pos 为 -1 或者链表中的一个 有效索引 。
//
// Related Topics 哈希表 链表 双指针
// 👍 1102 👎 0
public class Solution {


    /**
     * 哈希表法：
     * 遍历所有节点，并加入到哈希表中，如果某个节点已经存在哈希表中，则代表此前遍历过，也就是链表存在环
     * <p>
     * 时间复杂度：O(N)O(N)，其中 NN 是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
     * 空间复杂度：O(N)O(N)，其中 NN 是链表中的节点数。主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次。
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 双指针算法
     * <p>
     * 定义两个指针，
     * 快指针：每次前进两格
     * 慢指针：每次前进一格
     * 两个指针在链表上移动
     * <p>
     * 如果链表没有环，那么在结束之前，快指针将一直在慢指针的前面
     * 如果链表有环，那么由于存在速度差，快慢指针将在环中某个节点上相遇
     *
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 慢指针
        ListNode slow = head;

        // 快指针
        ListNode fast = head.next;

        // 如果两个节点没有相遇，就一直向下移动
        while (slow != fast) {
            // 快指针到达了链表的尾部，说明没有环
            if(fast == null || fast.next == null){
                return false;
            }

            // 慢指针前进一格
            slow = slow.next;

            // 快指针前进两格
            fast = fast.next.next;
        }

        // 没有进while循环，说明slow == fast，也就是快慢指针相遇了
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
