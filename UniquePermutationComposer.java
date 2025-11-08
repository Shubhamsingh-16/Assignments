import java.util.*;

class UniquePermutationComposer {

    public static List<List<Integer>> craftUniquePermutations(int[] nums) {
        Arrays.sort(nums); // sorting array so same numbers come near
        List<List<Integer>> result = new ArrayList<>(); // store all the unique permutations
        LinkedList<Integer> current = new LinkedList<>(); // to keep track what we choosed till now
        boolean[] used = new boolean[nums.length]; // tell which number is already used
        backtrackPermute(nums, used, current, result); // start doing recursion for making all combo
        return result; // finally give all permutations back
    }

    private static void backtrackPermute(int[] nums, boolean[] used,
                                         LinkedList<Integer> current,
                                         List<List<Integer>> result) {
        if (current.size() == nums.length) { // when current permutation is ready
            result.add(new ArrayList<>(current)); // add this permutation into final answer
            return; // go back and try something else
        }

        for (int i = 0; i < nums.length; i++) { // going through each element
            if (used[i]) continue; // skip this one if already used before

            // skip same value if it already appear before and last one was not used
            // because that will make same permutation again
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true; // mark this number that now it is used
            current.addLast(nums[i]); // put it inside current list

            backtrackPermute(nums, used, current, result); // call same function for next position

            current.removeLast(); // remove last one when we come back (undo step)
            used[i] = false; // mark it again as not used now
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2}; // input numbers with some repeat
        List<List<Integer>> perms = craftUniquePermutations(test); // make all different permutations
        System.out.println("Input: " + Arrays.toString(test)); // printing the input array
        System.out.println("Unique permutations: " + perms); // printing all possible different permutations
    }
}
