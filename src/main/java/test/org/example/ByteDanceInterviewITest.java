package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ByteDanceInterviewITest {
    private ByteDanceInterviewI byteDance = new ByteDanceInterviewI();

    @DisplayName("打家劫舍 II")
    @ParameterizedTest(name = "输入：{0}，期望输出：{1}")
    @MethodSource("testRobParamProvider")
    void testRob(int[] nums, int expectedAns) {
        assertEquals(expectedAns, byteDance.rob(nums));
    }

    public static Stream<Arguments> testRobParamProvider() {
        return Stream.of(
                arguments(new int[]{2, 3, 2}, 3),
                arguments(new int[]{1, 2, 3, 1}, 4),
                arguments(new int[]{1, 2, 3}, 3),
                arguments(new int[]{2}, 2),
                arguments(new int[]{1, 2}, 2)
        );
    }
}