package dynamic_programing_and_recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("getSubsetsRecursive(set, 0) = " + getSubsetsRecursive(set, 0));

    }

    // O(n2^n)
    private static ArrayList<ArrayList<Integer>> getSubsetsRecursive(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) { // base case
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());// Empty set
        } else {
            allSubsets = getSubsetsRecursive(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    /*
     * While there's nothing wrong with the above solution, there's another way to approach it.
     * Recall that when we're generating a set, we have two choices for each element:
     * (1) the element is in the set (the "yes" state) or (2) the element is not in the set (the "no" state).
     * This means that each subset is a sequence of yeses I nos-e.g., "yes, yes, no, no, yes, no"
     * This givesus 2^n possible subsets.How canweiteratethroughallpossiblesequencesof"yes"/"no"statesfor all elements?
     * If each "yes" can be treated as a 1 and each "no" can be treated as a 0, then each subset can be represented as a binary string.
     * Generating all subsets, then, really just comes down to generating all binary numbers (that is, all integers).
     * We iterate through all numbers from 0 to 2n (exclusive) and translate the binary representation of the numbers into a set. Easy!
     *
     *
     */
    private static ArrayList<ArrayList<Integer>> getSubsetsCombinatorics(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << set.size(); // calculate 2^n
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    private static ArrayList<Integer> convertIntToSet(int k, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int i = k; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;

    }

}
