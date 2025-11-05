// time complexity=O(n+m)  space complexity=O(n+m) 
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeArrays {

    // Recursive function to merge two sorted lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Base cases
        if (list1 == null) return list2;  // if list1 is empty, return list2
        if (list2 == null) return list1;  // if list2 is empty, return list1

        // Recursive step
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;  // list1 is smaller, so it’s the new head
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;  // list2 is smaller, so it’s the new head
        }
    }

    // Helper function to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Create first sorted list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Create second sorted list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Merge
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Print merged list: 1 2 3 4 5 6
        printList(mergedList);
    }
}
