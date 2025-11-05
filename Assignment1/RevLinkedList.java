// Time Complexity : O(n)
// Space Complexity : O(n)
// A simple node class that stores data and a pointer to the next node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RevLinkedList {

    // This will always point to the first node of our list
    static Node head;

    // Insert a new node at the end of the list
    static void insert(int data) {
        Node newNode = new Node(data);

        // If list is empty, the new node becomes the first node
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, keep moving until you reach the last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach the new node at the end
        temp.next = newNode;
    }

    // Print all nodes one by one
    static void print() {
        Node temp = head;

        // Just follow the chain until it ends
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null"); // End of list
    }

    // Recursively reverse the list
    static Node reverseRecursive(Node node) {

        // Base case:
        // 1. If list is empty (node == null)
        // 2. If you reached the last node (node.next == null)
        // In both cases, return the node as the new head
        if (node == null || node.next == null) {
            return node;
        }

        // Go deeper until you reach the last node
        Node newHead = reverseRecursive(node.next);

        // Reverse the link:
        // Make the next node point back to the current node
        node.next.next = node;

        // Break the old forward link
        node.next = null;

        // Always return the head of the reversed list
        return newHead;
    }

    public static void main(String[] args) {

        // Let's build a simple list: 1 -> 2 -> 3 -> 4
        insert(1);
        insert(2);
        insert(3);
        insert(4);

        System.out.println("Original list:");
        print();

        // Reverse the linked list using recursion
        head = reverseRecursive(head);

        System.out.println("Reversed list:");
        print();
    }
}