package com.dpc.algorithm.leetcode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

import com.dpc.algorithm.leetcode.datastructure.ListNode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int k = lists.length;
        ListNode[] hs = new ListNode[k];
        for (int i = 0; i < k; i++) {
            hs[i] = lists[i];
        }

        while (!allEnd(hs)) {
            Arrays.sort(hs, new Comparator<ListNode>() {
                public int compare(ListNode o1, ListNode o2) {
                    if (o1 == null && o2 == null) return 0;
                    if (o1 == null) return 1;
                    if (o2 == null) return -1;
                    return o1.val - o2.val;
                }
            });

            p.next = hs[0];
            hs[0] = hs[0].next;
            p = p.next;

        }


        return head.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int k = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < k; i++) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }

        return head.next;
    }

    private boolean allEnd(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }
}
