package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BackTrackingExercisesTest {
    BackTrackingExercises backTrackingExercises = new BackTrackingExercises();

    @DisplayName("剑指 Offer 38. 字符串的排列")
    @ParameterizedTest(name = "输入：{0}，期望输出：{1}")
    @MethodSource("testPermutationParamsProvider")
    void testPermutation(String s, String[] expectedAns) {
        String[] ans = backTrackingExercises.permutation(s);
        assertEquals(expectedAns.length, ans.length);
        HashSet<String> setExp = new HashSet<>(Arrays.asList(expectedAns));
        HashSet<String> setAns = new HashSet<>(Arrays.asList(ans));
        assertTrue(setAns.containsAll(setExp));
    }

    @DisplayName("剑指 Offer 38. 字符串的排列")
    @ParameterizedTest(name = "输入：{0}，期望输出：{1}")
    @MethodSource("testPermutationParamsProvider")
    void testpermutationBackTrackingTemplate(String s, String[] expectedAns) {
        String[] ans = backTrackingExercises.permutationBackTrackingTemplate(s);
        assertEquals(expectedAns.length, ans.length);
        HashSet<String> setExp = new HashSet<>(Arrays.asList(expectedAns));
        HashSet<String> setAns = new HashSet<>(Arrays.asList(ans));
        assertTrue(setAns.containsAll(setExp));
    }

    public static Stream<Arguments> testPermutationParamsProvider() {
        return Stream.of(
                arguments("abc", new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}),
                arguments("abb", new String[]{"abb", "bab", "bba"}),
                arguments("ab", new String[]{"ab", "ba"}),
                arguments("a", new String[]{"a"})
        );
    }
}