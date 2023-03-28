package org.example;

import org.example.Beans.ListNode;
import org.example.Beans.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.Beans.ListNode.initListNode;
import static org.example.Beans.TreeNode.initTreeNode;
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


    //TODO 二叉树不支持 null node 初始化
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

    @DisplayName("剑指 Offer 10- I. 斐波那契数列")
    @ParameterizedTest(name = "输入：{0},期望输出：{1}")
    @MethodSource("fibParamsProvider")
    void fib(int n, int exp) {
        assertEquals(exp, sword.fib(n));
    }

    public static Stream<Arguments> fibParamsProvider() {
        return Stream.of(
                arguments(2, 1),
                arguments(1, 1),
                arguments(3, 2),
                arguments(5, 5)
        );
    }

    @DisplayName("剑指 Offer 10- II. 青蛙跳台阶问题")
    @ParameterizedTest(name = "输入：{0},期望输出：{1}")
    @MethodSource("numWaysParamsProvider")
    void numWays(int n, int exp) {
        assertEquals(exp, sword.numWays(n));
        assertEquals(exp, sword.numWaysDp(n));
    }

    public static Stream<Arguments> numWaysParamsProvider() {
        return Stream.of(
                arguments(3, 3),
                arguments(7, 21),
                arguments(2, 2),
                arguments(0, 1)
        );
    }

    @DisplayName("剑指 Offer 63. 股票的最大利润")
    @ParameterizedTest(name = "输入：{0},期望输出：{1}")
    @MethodSource("maxProfitParamsProvider")
    void maxProfit(int[] prices, int exp) {
        assertEquals(exp, sword.maxProfit(prices));
    }

    public static Stream<Arguments> maxProfitParamsProvider() {
        return Stream.of(
                arguments(new int[]{7, 1, 5, 3, 6, 4}, 5),
                arguments(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @DisplayName("剑指 Offer 47. 礼物的最大价值")
    @ParameterizedTest(name = "输入：{0},期望输出：{1}")
    @MethodSource("maxValueParamsProvider")
    void maxValue(int[][] grid, int exp) {
        assertEquals(exp, sword.maxValue(grid));
    }

    public static Stream<Arguments> maxValueParamsProvider() {
        return Stream.of(
                arguments(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}, 12)
        );
    }

    @DisplayName("剑指 Offer 46. 把数字翻译成字符串")
    @ParameterizedTest(name = "输入：{0},期望输出：{1}")
    @MethodSource("translateNumParamsProvider")
    void translateNum(int num, int exp) {
        assertEquals(exp, sword.translateNum(num));
    }

    public static Stream<Arguments> translateNumParamsProvider() {
        return Stream.of(
                arguments(12258, 5)
        );
    }

    @DisplayName("剑指 Offer 48. 最长不含重复字符的子字符串")
    @ParameterizedTest(name = "输入：{0},期望输出：{1}")
    @MethodSource("lengthOfLongestSubstringParamsProvider")
    void lengthOfLongestSubstring(String s, int exp) {
        assertEquals(exp, sword.lengthOfLongestSubstring(s));
    }

    public static Stream<Arguments> lengthOfLongestSubstringParamsProvider() {
        return Stream.of(
                arguments("abcabcbb", 3),
                arguments("pwwkew", 3),
                arguments("bbbbb", 1)
        );
    }

    @DisplayName("剑指 Offer 18. 删除链表的节点")
    @ParameterizedTest(name = "输入：{0},期望输出：{2}")
    @MethodSource("deleteNodeParamsProvider")
    void deleteNode(ListNode head, int val, ListNode exp) {
        assertEquals(exp, sword.deleteNode(head, val));
    }

    public static Stream<Arguments> deleteNodeParamsProvider() {
        return Stream.of(
                arguments(initListNode(new int[]{4, 5, 1, 9}), 5, initListNode(new int[]{4, 1, 9})),
                arguments(initListNode(new int[]{4, 5, 1, 9}), 1, initListNode(new int[]{4, 5, 9}))
        );
    }


    @DisplayName("剑指 Offer 22. 链表中倒数第k个节点")
    @ParameterizedTest(name = "输入：{0},期望输出：{2}")
    @MethodSource("getKthFromEndParamsProvider")
    void getKthFromEnd(ListNode head, int k, ListNode exp) {
        assertEquals(exp, sword.getKthFromEnd(head, k));
    }

    public static Stream<Arguments> getKthFromEndParamsProvider() {
        return Stream.of(
//                arguments(initListNode(new int[]{1, 2, 3, 4, 5, 6}), 3, initListNode(new int[]{4, 5})),
                arguments(initListNode(new int[]{1, 2, 3, 4, 5}), 2, initListNode(new int[]{4, 5}))
        );
    }

    @DisplayName("剑指 Offer 25. 合并两个排序的链表")
    @ParameterizedTest(name = "输入：{0},{1},期望输出：{2}")
    @MethodSource("mergeTwoListsParamsProvider")
    void mergeTwoLists(ListNode l1, ListNode l2, ListNode exp) {
        assertEquals(exp, sword.mergeTwoLists(l1, l2));
    }

    public static Stream<Arguments> mergeTwoListsParamsProvider() {
        return Stream.of(
                arguments(
                        initListNode(new int[]{2, 4, 6, 8, 10}),
                        initListNode(new int[]{1, 3, 5, 7, 9}),
                        initListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                ),
                arguments(
                        initListNode(new int[]{1, 2, 4}),
                        initListNode(new int[]{1, 3, 4}),
                        initListNode(new int[]{1, 1, 2, 3, 4})
                )
        );
    }

    @DisplayName("剑指 Offer 52. 两个链表的第一个公共节点")
    @ParameterizedTest(name = "输入：{0},{1},期望输出：{2}")
    @MethodSource("getIntersectionNodeParamsProvider")
    void getIntersectionNode(ListNode l1, ListNode l2, ListNode exp) {
        ListNode res = sword.getIntersectionNode(l1, l2);
        assertEquals(exp, res, "实际输出：" + res);
    }

    public static Stream<Arguments> getIntersectionNodeParamsProvider() {
        return Stream.of(
                arguments(
                        initListNode(new int[]{0, 9, 1, 2, 4}),
                        initListNode(new int[]{3, 2, 4}),
                        initListNode(new int[]{2, 4})
                ),
                arguments(
                        initListNode(new int[]{4, 1, 8, 4, 5}),
                        initListNode(new int[]{5, 0, 1, 8, 4, 5}),
                        initListNode(new int[]{8, 4, 5})
                ),
                arguments(
                        initListNode(new int[]{2, 6, 8}),
                        initListNode(new int[]{5, 0}),
                        null)

        );
    }


}