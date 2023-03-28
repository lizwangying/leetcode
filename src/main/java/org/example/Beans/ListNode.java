package org.example.Beans;

import java.util.Objects;

/**
 * @Desc : 链表的节点
 * @Author : Liz</p>
 * @Date : 2023/3/22</p>
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode node) {
        this.val = node.val;
        this.next = node.next;
    }

    public static ListNode initListNode(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        for (int i = 0; i < numbers.length; i++) {
            ListNode currNode = new ListNode(numbers[i]);
            preNode.next = currNode;
            preNode = preNode.next;
        }
        return dummyNode.next;
    }

    @Override
    public String toString() {
        if (val == null) {
            return "[]";
        } else if (next == null) {
            return "[" + val + "]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode tmp = new ListNode(this);
        while (tmp.next != null) {
            sb.append(tmp.val);
            if (tmp.val != null) {
                sb.append(",");
            }
            tmp = tmp.next;
        }
        sb.append(tmp.val).append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListNode)) return false;
        ListNode compareNode = (ListNode) obj;
        return recurCompare(compareNode);
    }

    private boolean recurCompare(ListNode node) {
        if (node == null && this.val == null) return true;
        if (node == null) return false;
        if (Objects.equals(node.val, this.val)) {
            if (node.next != null) {
                recurCompare(node.next);
            }
            return true;
        } else {
            return false;
        }
    }
}
