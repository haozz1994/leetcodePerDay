package com.haozz.leetcode.leetcode202007.leetcode20200714;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * <p>
 * 599. 两个列表的最小索引总和
 * <p>
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 * <p>
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 */
public class Solution {

    /**
     * 方法 1：使用哈希表 [Accepted]  HashMap
     * 在这种方法中，我们枚举 list1 中的每一个字符串，遍历整个 list2 一遍，对每一对字符串都进行比较。我们使用哈希表 map，它包含了形如 (sum: list_{sum})的元素。这里 sum 是匹配元素的下标和，list_{sum}是下标和为 sum 的匹配字符串列表。
     * <p>
     * 这样，通过比较，一旦 list1 中第 i 个字符串和 list2 中第 j 个字符串匹配，如果 sum 为 i+j 的条目在 map 中还没有，我们就加一个条目。如果已经存在，由于我们需要保存所有下标和相同的字符串对，所以我们将这对字符串保存到哈希表中。
     * <p>
     * 最后我们遍历 map 的键一遍，并找到下标和最小的字符串列表。
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(l1 * l2 * x)。list1 中的每个字符串都与 list2 中的字符串进行了比较。l1和l2是 list1 和 list2 列表的长度，x 是字符串的平均长度。
     * <p>
     * 空间复杂度：O(l1 * l2 * x)。最坏情况下，list1 和 list2 中所有字符串都相同，那么哈希表最大会变成 l1 * l2 * x，其中 x 是字符串的平均长度。
     * <p>
     * <不理解这里和字符串长度有什么关系>
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<String>());
                    }
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            min_index_sum = Math.min(min_index_sum, key);
        }
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }


    /**
     * 方法 2： 不使用哈希表 [Accepted]
     * 算法
     * <p>
     * 另一种也可以遍历不同 sum (下标和)，并判断是否有字符串分别出现在 list1 和 list2 中且下标和为 sum。
     * <p>
     * 现在我们知道下标和的值 sum 数值范围从 0 到 m+n−1。这里 m 和 n 分别是 list1 和 list2 的长度，我们现在可以升序枚举 sum ，对于每个 sum，我们遍历 list1，假设当前下标为 i，为了得到下标和 sum，list2 中的下标 j 为 sum−i。通过这样的办法，我们不需要遍历 list2，而可以直接通过计算得到在 list2 中对应的下标。
     * <p>
     * 对于每个 sum，我们遍历 list1 的所有下标，一旦有 list1 和 list2 中的字符串匹配，就把匹配字符串放入一个 res 列表中。
     * <p>
     * 我们对 sum 升序数组中所有值做相同的过程，对于每个 sum 遍历完一遍 list1 之后，我们检查 res 列表是否为空。如果是空的，我们继续遍历下一个 sum 数组。如果不为空，当前的 res 就是最小下标和的数组。这是因为我们遍历 sum 的顺序是升序的，所以第一个找到的列表就是结果列表。
     * <p>
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O((l1+l2)^2*x)。两重嵌套循环，每一层最多到 l1+l2 ，比较字符串需要花费 x 的时间，这里 x 是字符串的平均长度。
     * <p>
     * 空间复杂度：O(r*x)。res 是结果字符串列表，r 是 res 的长度。
     */
    public String[] findRestaurant1(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        for (int sum = 0; sum < list1.length + list2.length - 1; sum++) {
            for (int i = 0; i <= sum; i++) {
                if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i])) {
                    res.add(list1[i]);
                }
            }
            if (res.size() > 0) {
                break;
            }
        }
        return res.toArray(new String[res.size()]);
    }

}
