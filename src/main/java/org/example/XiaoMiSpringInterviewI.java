package org.example;

import java.util.*;

/**
 * 小米春招备战题单
 * 1.数组、双指针、排序
 * 88.合并两个有序数组
 * 15. 三数之和
 * 242. 有效的字母异位词
 * 3. 无重复字符的最长子串 （双指针的类型一：同向双指针，类似题目： 713. 乘积小于 K 的子数组，长度最小的子数组）
 * 17. 电话号码的字母组合
 * 231. 2 的幂
 * 78. 子集
 */
public class XiaoMiSpringInterviewI {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * 提示：
     * 3 <= nums.length <= 3000
     * -10^5 <= nums[i] <= 10^5
     * 链接：<a href="https://leetcode.cn/problems/3sum">15. 三数之和</a>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序 O=nlogn
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) return lists;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L < R && nums[L + 1] == nums[L]) ++L;
                    while (L < R && nums[R - 1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if (tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

    /**
     * 242. 有效的字母异位词
     * <a href="https://leetcode.cn/problems/valid-anagram">链接</a>
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * 示例1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 提示:
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
     * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">链接</a>
     * 示例1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     * 提示：
     * 0 <= s.length <= 5 * 104
     * s由英文字母、数字、符号和空格组成
     * 类似题目：
     * 713.乘积小于 K 的子数组 <a href="https://leetcode.cn/problems/subarray-product-less-than-k/solution/xia-biao-zong-suan-cuo-qing-kan-zhe-by-e-jebq/">乘积小于 K 的子数组</a>
     * 209.长度最小的子数组 <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/solution/biao-ti-xia-biao-zong-suan-cuo-qing-kan-k81nh/">长度最小的子数组 </a>
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int right = 0;
        int ans = 0;
        HashSet<Character> window = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                window.remove(s.charAt(i - 1));
            }
            while (right < n && !window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - i);
        }
        return ans;
    }

    /**
     * 17. 电话号码的字母组合
     * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number">链接</a>
     * 考点：回溯
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     * 提示：
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        HashMap<Character, String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        backtrack(ans, dict, digits, 0, new StringBuffer());
        return ans;
    }

    /**
     * 回溯三问
     * 1. 当前操作？枚举`path[i]`要填入的字母
     * 2. 子问题？构造字符串`>=i`的部分
     * 3. 下一个子问题？构造字符串`>=i+1`的部分
     * ---------------------------------------
     * 17. 电话号码的字母组合 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solutions/2059416/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-3orv/
     * 78. 子集 https://leetcode.cn/problems/subsets/solutions/2059409/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-8tkl/
     * 131. 分割回文串 https://leetcode.cn/problems/palindrome-partitioning/solutions/2059414/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-fues/
     * 784. 字母大小写全排列 https://leetcode.cn/problems/letter-case-permutation/
     * 1601. 最多可达成的换楼请求数目 https://leetcode.cn/problems/maximum-number-of-achievable-transfer-requests/
     * 2397. 被列覆盖的最多行数 https://leetcode.cn/problems/maximum-rows-covered-by-columns/
     */
    private void backtrack(List<String> ans, HashMap<Character, String> dict, String digits, int path, StringBuffer combination) {
        if (path == digits.length()) {
            ans.add(combination.toString());
        } else {
            char digit = digits.charAt(path);
            String letters = dict.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                //在path后面添加元素，所以在递归之前什么样，之后就要`恢复现场`
                //path表示路径上的数字。比如枚举1，然后枚举2，1和2在不同的分支上，那么必然不会在同一条路径中。先递归1，把1加到path中，
                // 然后递归2，如果不把1去掉的话，1和2就都在path中，这就错了，期望是path中只有2，那么把1去掉把2加进去，就可以满足要求了。
                backtrack(ans, dict, digits, path + 1, combination);
                //这里`恢复现场`
                combination.deleteCharAt(path);
            }
        }
    }

    /**
     * 231. 2 的幂
     * <a href="https://leetcode.cn/problems/power-of-two">链接</a>
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     * 示例 1：
     * 输入：n = 1
     * 输出：true
     * 解释：2^0 = 1
     * 示例 2：
     * 输入：n = 16
     * 输出：true
     * 解释：2^4 = 16
     * 示例 3：
     * 输入：n = 3
     * 输出：false
     * 示例 4：
     * 输入：n = 4
     * 输出：true
     * 示例 5：
     * 输入：n = 5
     * 输出：false
     * 提示：
     * -231 <= n <= 231 - 1
     * 进阶：你能够不使用循环/递归解决此问题吗？
     */
    public boolean isPowerOfTwo(int n) {
        //方法一
        return n > 0 && (n & (n - 1)) == 0;
        //方法二
        //return n > 0 && (n & -n) == n;
    }

    /**
     * 78. 子集
     * <a href="https://leetcode.cn/problems/subsets">链接</a>
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * 提示：
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //先写非边界条件，不选，直接跳到i+1
        dfs(i + 1);
        //选
        path.add(nums[i]);
        dfs(i + 1);
        //恢复现场
        path.remove(path.size() - 1);
    }


}
