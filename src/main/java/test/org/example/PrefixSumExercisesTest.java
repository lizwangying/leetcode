package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class PrefixSumExercisesTest {
    //    @DisplayName("PrefixSumTest")
//    @ParameterizedTest
//    @CsvFileSource(resources = "./PrefixSumTest.csv")
//    void findLongestSubArray() {
//        PrefixSumExercises test = new PrefixSumExercises();
//        test.findLongestSubArray()
//    }
    private final PrefixSumExercises p = new PrefixSumExercises();

    @DisplayName("一维数组的动态和")
    @ParameterizedTest(name = "输入：{0}, 输出: {1}")
    @MethodSource("arrayInputAndOutPutProvider")
    void testRunningSum(int[] nums, int[] ans) {
        assertArrayEquals(p.runningSum(nums), ans);
    }

    public static Stream<Arguments> arrayInputAndOutPutProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}),
                arguments(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}),
                arguments(new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17}),
                arguments(new int[]{1}, new int[]{1})
        );
    }

    @DisplayName("返回字母与数字个数相同的子数组")
    @ParameterizedTest(name = "输入 {0}, 输出 {1}")
    @MethodSource("stringArrayProvider")
    void testFindLongestSubArray(String[] input, String[] output) {
        assertArrayEquals(p.findLongestSubArray(input), output);
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                arguments(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"}, new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7"}),
                arguments(new String[]{"A", "A"}, new String[]{}),
                arguments(new String[]{}, new String[]{})
        );
    }

    @DisplayName("连续和为K的子数组")
    @ParameterizedTest(name = "输入 nums = {0}, k = {1}")
    @MethodSource("stringArrayProvider_testSubArraySum")
    void testSubArraySumEnum(int[] nums, int k, int result) {
        assertEquals(p.subArraySumEnum(nums, k), result);
        assertEquals(p.subArraySumHash(nums, k), result);
        assertEquals(p.subArraySum(nums, k), result);
    }

    static Stream<Arguments> stringArrayProvider_testSubArraySum() {
        return Stream.of(
                arguments(new int[]{1, 1, 1}, 2, 2),
                arguments(new int[]{1, 2, 3}, 3, 2)
        );
    }

    @DisplayName("长度最小的子数组")
    @ParameterizedTest(name = "")
    void testMinSubArrayLen(){

    }
}
