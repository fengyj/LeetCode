package me.fengyj.leetcode.jian_zhi_offer;

import java.util.*;

public class No_35_Copy_Random_Link_List {

    public Node copyRandomList_1(Node head) {
        
        Node node = head;
        Node copiedHead = null;
        Node copiedNode = null;
        Map<Node, Node> mapping = new HashMap<>();
        while(node != null) {

            Node copied = new Node(node.val);
            if(copiedHead == null) copiedHead = copied;
            if(copiedNode != null) copiedNode.next = copied;
            copiedNode = copied;

            mapping.put(node, copied);

            node = node.next;
        }
        node = head;
        while(node != null) {
            if(node.random != null) {

                var copied = mapping.get(node);
                var copiedRandom = mapping.get(node.random);
                copied.random = copiedRandom;
            }
            node = node.next;
        }

        return copiedHead;
    }

    public Node copyRandomList_2(Node head) {

        Node node = head;
        Node copiedHead = null;
        Node copiedNode = null;
        int i = 0;
        while(node != null) {
            
            Node copied = new Node(node.val);
            if(copiedHead == null) copiedHead = copied;
            if(copiedNode != null) copiedNode.next = copied;
            copiedNode = copied;

            node.val = i++;
            node = node.next;
        }
        node = head;
        copiedNode = copiedHead;
        while(node != null) {
            if(node.random != null) {
                var val = node.random.val;
                i = 0;
                Node copiedRandomNode = null;
                while(i <= val) {
                    copiedRandomNode = copiedRandomNode == null ? copiedHead : copiedRandomNode.next;
                    i++;
                }
                copiedNode.random = copiedRandomNode;
            }
            node = node.next;
            copiedNode = copiedNode.next;
        }
        
        node = head;
        copiedNode = copiedHead;
        while(node != null) {
            node.val = copiedNode.val;
            node = node.next;
            copiedNode = copiedNode.next;
        }

        return copiedHead;
    }
 
    public Node copyRandomList_3(Node head) {

        Node copiedHead = null;

        Node node = head;
        while(node != null) {

            Node copied = new Node(node.val);
            copied.next = node.next;
            copied.random = node.random;
            
            node.next = copied;
            node = copied.next;
        }
        node = head;
        while(node != null) {

            Node copied = node.next;
            if(copied.random != null) copied.random = copied.random.next;

            node = node.next.next;
        }
        node = head;
        while(node != null) {

            Node copied = node.next;
            if(copiedHead == null) copiedHead = copied;

            node.next = node.next.next;
            copied.next = copied.next == null ? null : copied.next.next;

            node = node.next;
        }

        return copiedHead;
    }

    class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
}
