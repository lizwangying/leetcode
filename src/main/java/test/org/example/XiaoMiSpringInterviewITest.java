package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class XiaoMiSpringInterviewITest {

    public XiaoMiSpringInterviewI xiaomi = new XiaoMiSpringInterviewI();

    @DisplayName("三数之和为0")
    @ParameterizedTest(name = "输入：{0}, 期望输出：{1}")
    @MethodSource("threeSumParameterProvider")
    void testThreeSumExpectSumEqualsZero(int[] nums, List<List<Integer>> expectedList) {
        List<List<Integer>> resultList = xiaomi.threeSum(nums);
        assertTrue(resultList.size() == expectedList.size() && resultList.containsAll(expectedList));
    }

    public static Stream<Arguments> threeSumParameterProvider() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))),
                arguments(new int[]{0, 1, 1}, new ArrayList<List<Integer>>()),
                arguments(new int[]{0, 0, 0}, Arrays.asList(Arrays.asList(0, 0, 0))),
                arguments(new int[]{-2, 0, 1, 1, 2}, Arrays.asList(Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1)))
        );
    }

    @DisplayName("有效的字母异位词")
    @ParameterizedTest(name = "s: {0},s: {1},expectedReturnResult: {2}")
    @MethodSource("testIsAnagramParamProvider")
    void testIsAnagram(String s, String t, boolean expectedReturnResult) {
        assertEquals(xiaomi.isAnagram(s, t), expectedReturnResult);
    }

    public static Stream<Arguments> testIsAnagramParamProvider() {
        return Stream.of(
                arguments("anagram", "nagaram", true),
                arguments("rat", "car", false),
                arguments("", "car", false),
                arguments("fess", "car", false),
                arguments("fess", "ssef", true)
        );
    }

    @DisplayName("无重复字符的最长子串")
    @ParameterizedTest(name = "输入：{0}, 期望结果：{1}")
    @MethodSource("testLengthOfLongestSubstringParamProvider")
    void testLengthOfLongestSubstring(String s, int expectedAns) {
        assertEquals(expectedAns, xiaomi.lengthOfLongestSubstring(s));
    }

    public static Stream<Arguments> testLengthOfLongestSubstringParamProvider() {
        return Stream.of(
                arguments("abcabcbb", 3),
                arguments("bbbbb", 1),
                arguments("pwwkew", 3)
        );
    }

    @DisplayName("电话号码的字母组合")
    @ParameterizedTest(name = "输入：{0}，期望输出 {1}")
    @MethodSource("testletterCombinationsParamProvider")
    void testletterCombinations(String digits, List<String> expected) {
        List<String> ansList = xiaomi.letterCombinations(digits);
        assertTrue(ansList.size() == expected.size() && expected.containsAll(ansList));
    }

    public static Stream<Arguments> testletterCombinationsParamProvider() {
        return Stream.of(
                arguments("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                arguments("", Collections.emptyList()),
                arguments("2", Arrays.asList("a", "b", "c")),
                arguments("79", Arrays.asList("pw", "px", "py", "pz", "qw", "qx", "qy", "qz", "rw", "rx", "ry", "rz", "sw", "sx", "sy", "sz"))
        );
    }

    @DisplayName("2的幂")
    @ParameterizedTest(name = "输入：{0},期望输出: {1}")
    @MethodSource("testIsPowerOfTwoParamProvider")
    void testIsPowerOfTwo(int n, boolean ansExpected) {
        assertEquals(ansExpected, xiaomi.isPowerOfTwo(n));
    }

    public static Stream<Arguments> testIsPowerOfTwoParamProvider() {
        return Stream.of(
                arguments(1, true),
                arguments(16, true),
                arguments(3, false),
                arguments(4, true),
                arguments(5, false),
                arguments(-5, false),
                arguments(-4, false),
                arguments(0, false)
        );
    }

    @DisplayName("子集")
    @ParameterizedTest(name = "输入{0},期待输出:{1}")
    @MethodSource("testSubsetsParamProvider")
    void testSubsets(int[] nums, List<List<Integer>> ansExpected) {
        List<List<Integer>> tmp = xiaomi.subsets(nums);
        assertTrue(tmp.size() == ansExpected.size() && ansExpected.containsAll(tmp));
    }

    public static Stream<Arguments> testSubsetsParamProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, Arrays.asList(
                        Collections.emptyList(),
                        Collections.singletonList(1),
                        Collections.singletonList(2),
                        Arrays.asList(1, 2),
                        Collections.singletonList(3),
                        Arrays.asList(1, 3),
                        Arrays.asList(2, 3),
                        Arrays.asList(1, 2, 3)
                )),
                arguments(new int[]{0}, Arrays.asList(
                        Collections.emptyList(),
                        Collections.singletonList(0)
                ))
        );
    }
}