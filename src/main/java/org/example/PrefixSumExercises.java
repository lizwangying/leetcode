package org.example;

import java.util.HashMap;

/**
 * 前缀和练习
 * ✔ 1480. 一维数组的动态和
 * ✔ 560. 和为 K 的子数组
 *  209. 长度最小的子数组
 * ✔ 面试题 17.05.  字母与数字
 * 930. 和相同的二元子数组
 * 974. 和可被 K 整除的子数组
 * 1590. 使数组和能被 P 整除
 * 523. 连续的子数组和
 * 525. 连续数组
 * 724. 寻找数组的中心索引
 * 1248. 统计「优美子数组」
 */
public class PrefixSumExercises {
    /**
     * 1480. 一维数组的动态和
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     * 示例 2：
     * 输入：nums = [1,1,1,1,1]
     * 输出：[1,2,3,4,5]
     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
     * 示例 3：
     * 输入：nums = [3,1,2,10,1]
     * 输出：[3,4,6,16,17]
     * 提示：
     * 1 <= nums.length <= 1000
     * -10^6 <= nums[i] <= 10^6
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    /**
     * 面试题 17.05.字母与数字
     * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
     * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
     * 示例 1:
     * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
     * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
     * 示例 2:
     * 输入: ["A","A"]
     * 输出: []
     * array.length <= 100000
     * 链接：<a href="https://leetcode.cn/problems/find-longest-subarray-lcci">面试题 17.05.字母与数字</a>
     */
    public String[] findLongestSubArray(String[] array) {
        int n = array.length;
        int[] s = new int[n + 1]; // 前缀和
        for (int i = 0; i < n; ++i)
            s[i + 1] = s[i] + (array[i].charAt(0) >> 6 & 1) * 2 - 1;

        int begin = 0, end = 0; // 符合要求的子数组 [begin,end)
        HashMap<Integer, Integer> first = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n; ++i) {
            int j = first.getOrDefault(s[i], -1);
            if (j < 0) // 首次遇到 s[i]
                first.put(s[i], i);
            else if (i - j > end - begin) { // 更长的子数组
                begin = j;
                end = i;
            }
        }
        String[] sub = new String[end - begin];
        System.arraycopy(array, begin, sub, 0, sub.length);
        return sub;
    }

    /**
     * 560. 连续和为K的子数组
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * 提示：
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */
    public int subArraySumEnum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subArraySum(int[] sum, int k) {
        int n = sum.length;
        int[] prefixSum = new int[sum.length + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + sum[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //这里因为前缀和数组比原数组长1， 所以是 j+1
                if (prefixSum[j + 1] - prefixSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subArraySumHash(int[] nums, int k) {
        int count = 0, preSum = 0;
        HashMap<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    /**
     * 209. 长度最小的子数组
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组[4,3]是该条件下的长度最小的子数组。
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * 提示：
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * 进阶：
     * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
     */
    public int minSubArrayLen(int target, int[] nums) {
        return 0;
    }

}
