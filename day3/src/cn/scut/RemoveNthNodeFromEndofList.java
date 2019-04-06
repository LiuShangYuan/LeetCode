package cn.scut;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveNthNodeFromEndofList {
    /**
     * 删除链表的倒数第n个节点
     * <p>
     * 思路:
     * 1)先翻转链表
     * 2)反转后正向第n个断开
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 反转
        ListNode p = head.next;
        head.next = null;

        ListNode tmp;
        ListNode q;
        while (p != null) {
            tmp = head.next;
            head.next = p;
            q = p.next;
            p.next = tmp;
            p = q;
        }


        ListNode t = head.next;
        ListNode previous = head;
        int current = 0;
        //删除
        while (t != null) {
            current++;
            if (current == n) {
                previous.next = t.next;
                break;
            }

            previous = t;
            t = t.next;
        }


        p = head.next;
        head.next = null;
        // 反转
        while (p != null) {
            tmp = head.next;
            head.next = p;
            q = p.next;
            p.next = tmp;
            p = q;
        }

        return head;
    }


    public static void main(String[] args) {

//        ListNode head = new ListNode(0);
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;


        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        node1.next = null;
        ListNode p = head.next;

        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }


        ListNode rhead = removeNthFromEnd(head, 1);

        System.out.println("---");

        p = rhead.next;

        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }



    }
}
