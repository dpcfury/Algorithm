import com.dpc.algorithm.leetcode.BinaryTreeMaximumPathSum_123;
import com.dpc.algorithm.leetcode.MergekSortedLists_23;
import com.dpc.algorithm.leetcode.datastructure.ListNode;
import org.junit.Test;

public class LeetcodeTest {

    @Test
    public void testMergeKSortedList() {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(4);
        ListNode node_3 = new ListNode(5);
        node_1.next = node_2;
        node_2.next = node_3;

        ListNode node_4 = new ListNode(1);
        ListNode node_5 = new ListNode(3);
        ListNode node_6 = new ListNode(4);
        node_4.next = node_5;
        node_5.next = node_6;

        ListNode node_7 = new ListNode(2);
        ListNode node_8 = new ListNode(6);
        node_7.next = node_8;

        ListNode[] lists = new ListNode[3];
        lists[0] = node_1;
        lists[1] = node_4;
        lists[2] = node_7;

        MergekSortedLists_23 m = new MergekSortedLists_23();
        ListNode head = m.mergeKLists1(lists);

        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }
}
