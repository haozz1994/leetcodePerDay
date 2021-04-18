package com.haozz.leetcode.leetcode202104.leetcode20210413;

import java.util.*;

/**
 * @author haozhezhe@yunquna.com
 * @date 9:52 PM 4/13/21
 */
public class Solution {

    public static void main(String[] args) {
        topKFrequent(new String[]{"i", "lc", "lc", "java", "lc", "java","a","a","a","a","a","a","a"}, 2);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2));

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
