package org.example;

public class LinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;

            curr.next = new ListNode(digit);
            curr = curr.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Create the first linked list: 3 → 2 → 1
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);

        // Create the second linked list: 6 → 5 → 4
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1, l2);

        // Print the sum of the two numbers in reverse-digit format
        while (sum != null) {
            System.out.print(sum.val);
            sum = sum.next;
            if (sum != null) {
                System.out.print(" -> ");
            }
        }
    }
}
