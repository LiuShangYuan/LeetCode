package cn.scut;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


// 1)按照map的方式两个两个merge
//         189ms
// 2)使用PriorityQueue实现(小顶堆)
//   将每个链表当前的第一个节点加入PriorityQueue
//         40ms(30%多)
// 3)完全使用PriorityQueue来实现
//         5ms (93%)
//   使用小顶堆对所有数据排序, 在构造成一个链表

public class MergeKSortedLists {

    public ListNode mergeKLists_v2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }


        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (o1, o2) -> {
            return Integer.compare(o1.val, o2.val);
        });

        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null) {
                pq.offer(lists[i]);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur_p = head;

        while (!pq.isEmpty()) {
            cur_p.next = pq.poll();
            cur_p = cur_p.next;

            if (cur_p.next != null) {
                pq.add(cur_p.next);
            }
        }


        return head.next;
    }

    //
    public ListNode mergeKLists_v3(ListNode[] lists){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        ListNode head = new ListNode(-1);
        ListNode p = head;

        for(int i=0; i<lists.length; i++){
            ListNode list = lists[i];
            while(list!=null){
                p.next = list;
                p = p.next;
                queue.add(list.val);
                list = list.next;
            }
        }

        p = head;
        while(!queue.isEmpty()){
//            p.next = new ListNode(queue.poll());
            p.next.val = queue.poll();
            p = p.next;
        }
        return head.next;
    }


    public ListNode mergeKLists_v1(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }


        for (int i = 0; i < lists.length - 1; i++) {
            ListNode newnode = merge2List(lists[i], lists[i + 1]);
            lists[i + 1] = newnode;
        }

        return lists[lists.length - 1];
    }

    public ListNode merge2List(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                p.next = node2;
                p = node2;
                node2 = node2.next;
            } else {
                p.next = node1;
                p = node1;
                node1 = node1.next;
            }
        }

        while (node1 != null) {
            p.next = node1;
            p = node1;
            node1 = node1.next;
        }

        while (node2 != null) {
            p.next = node2;
            p = node2;
            node2 = node2.next;
        }


        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        l1.next = node1;
        node1.next = node2;

        ListNode l2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        l2.next = node3;
        node3.next = node4;

        ListNode l3 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        l3.next = node5;


        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode node = new MergeKSortedLists().mergeKLists_v2(lists);

        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }

    }
}
