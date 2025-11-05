public class RevArray {

    // Recursive function to reverse array between given indexes
    static void reverseArray(int[] a, int start, int end) {

        // Base case: when pointers cross or meet, stop recursion
        if (start >= end)
            return;

        // Swap the elements at 'start' and 'end'
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;

        // Move towards the center
        reverseArray(a, start + 1, end - 1);
    }

    // Print all elements of the array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.print("Original Array: ");
        printArray(arr);

        // Start reversing from index 0 to last index
        reverseArray(arr, 0, arr.length - 1);

        System.out.print("Reversed Array: ");
        printArray(arr);
    }
}