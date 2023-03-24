package org.example;


import java.util.LinkedList;

/**
 * <p>剑指Offer I</p>
 * <p>剑指 Offer 26. 树的子结构</p>
 * <p>剑指 Offer 27. 二叉树的镜像</p>
 * <p>剑指 Offer 28. 对称的二叉树</p>
 * <p>剑指 Offer 10- I. 斐波那契数列</p>
 */
public class SwordAimingOfferI {
    /**
     * 剑指 Offer 26. 树的子结构
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * 示例 1：
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     * 限制：
     * 0 <= 节点个数 <= 10000
     * <a href="https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof">link</a>
     */
    public boolean isSubStructureBFS(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == B.val) {
                if (match(node, B)) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    private boolean match(TreeNode A, TreeNode B) {
        LinkedList<TreeNode> queueA = new LinkedList<>();
        LinkedList<TreeNode> queueB = new LinkedList<>();
        queueA.offer(A);
        queueB.offer(B);
        while (!queueB.isEmpty()) {
            TreeNode b = queueB.poll();
            TreeNode a = queueA.poll();
            if (a == null || b.val != a.val) {
                return false;
            }
            if (b.left != null) {
                queueB.add(b.left);
                queueA.add(a.left);
            }
            if (b.right != null) {
                queueB.add(b.right);
                queueA.add(a.right);
            }
        }
        return true;
    }

    public boolean isSubStructureDFS(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (dfs(A, B) || isSubStructureDFS(A.right, B) || isSubStructureDFS(A.left, B));
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }

    /**
     * 剑指 Offer 27. 二叉树的镜像<br/>
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * 限制：
     * 0 <= 节点个数 <= 1000
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 剑指 Offer 28. 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * 限制：
     * 0 <= 节点个数 <= 1000
     * 链接：<a href="https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof">link</a>
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0, F(1)= 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     * 提示：
     * 0 <= n <= 100
     * 链接：<a href="https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof">click</a>
     */
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
