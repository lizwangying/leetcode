package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.TreeNode.initTreeNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @Desc : 剑指 Offer test cases
 * @Author : Liz</p>
 * @Date : 2023/3/22</p>
 */
class SwordAimingOfferITest {
    SwordAimingOfferI sword = new SwordAimingOfferI();

    @DisplayName("剑指 Offer 26. 树的子结构")
    @ParameterizedTest(name = "输入：{0},{1} 期望输出：{2}")
    @MethodSource("testIsSubStructureParamProvider")
    void testIsSubStructureBFS(TreeNode A, TreeNode B, boolean expectedValue) {
        assertEquals(expectedValue, sword.isSubStructureBFS(A, B));
    }

    @DisplayName("剑指 Offer 26. 树的子结构")
    @ParameterizedTest(name = "输入：{0},{1} 期望输出：{2}")
    @MethodSource("testIsSubStructureParamProvider")
    void testIsSubStructureDFS(TreeNode A, TreeNode B, boolean expectedValue) {
        assertEquals(expectedValue, sword.isSubStructureDFS(A, B));
    }

    public static Stream<Arguments> testIsSubStructureParamProvider() {
        return Stream.of(
                arguments(initTreeNode(new Integer[]{1, 2, 3}), initTreeNode(new Integer[]{3, 1}), false),
                arguments(initTreeNode(new Integer[]{3, 4, 5, 1, 2}), initTreeNode(new Integer[]{4, 1, 2}), true)
        );
    }

    @DisplayName("剑指 Offer 27. 二叉树的镜像")
    @ParameterizedTest(name = "输入：{0}， 期望输出: {1}")
    @MethodSource("testMirrorTreeParamsProvider")
    void testMirrorTree(TreeNode node, TreeNode exp) {
        assertEquals(sword.mirrorTree(node), exp);
    }

    public static Stream<Arguments> testMirrorTreeParamsProvider() {
        return Stream.of(
                arguments(initTreeNode(new Integer[]{4, 2, 7, 1, 3, 6, 9}), initTreeNode(new Integer[]{4, 7, 2, 9, 6, 3, 1}))
        );
    }

    @DisplayName("剑指 Offer 10- I. 斐波那契数列")
    @ParameterizedTest(name = "输入：{0},期望输出：{1}")
    @MethodSource("fibParamsProvider")
    void fib(int n, int exp) {
        assertEquals(exp, sword.fib(n));
    }

    public static Stream<Arguments> fibParamsProvider() {
        return Stream.of(
                arguments(2, 1),
                arguments(5, 5)
        );
    }

//    @DisplayName("剑指 Offer 28. 对称的二叉树")
//    @ParameterizedTest(name = "输入：{0}，期望输出:{1}")
//    @MethodSource("testIsSymmetricParamsProvider")
//    void testIsSymmetric(TreeNode root, boolean exp) {
//        assertEquals(exp, sword.isSymmetric(root));
//    }
//
//    public static Stream<Arguments> testIsSymmetricParamsProvider() {
//        return Stream.of(
//                arguments(initTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3}), true),
//                arguments(initTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3}), false)
//        );
//    }
}