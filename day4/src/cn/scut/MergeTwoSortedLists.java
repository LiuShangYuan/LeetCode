package cn.scut;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class MergeTwoSortedLists {


    /**
     * 双指针
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        head.next = null;
        ListNode p = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        while(l1!=null){

            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }

        while (l2!=null){
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);

        node11.next = node12;
        node12.next = node13;
        node13.next = null;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);

        node21.next = node22;
        node22.next = node23;
        node23.next = null;


        ListNode result = mergeTwoLists(node11, node21);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
