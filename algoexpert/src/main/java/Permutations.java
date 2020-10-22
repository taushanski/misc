import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3);
        System.out.println("getPermutations(array) = " + getPermutations(array));
        System.out.println(array);
        System.out.println("getPermutationsOptimized(array) = " + getPermutationsOptimized(array));
    }

    /*Complexity: O(n^2*n!) time | O(n*n!) space*/

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutationHelper(array, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void getPermutationHelper(List<Integer> array, List<Integer> permutation,
                                             List<List<Integer>> permutations) {
        if (array.isEmpty() && !permutation.isEmpty()) { // the base case ->  we have a full permutation
            permutations.add(permutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(array.get(i));
                List<Integer> copy = copyListAndRemoveElement(array, i);
                getPermutationHelper(copy, newPermutation, permutations);
            }
        }

    }

    private static List<Integer> copyListAndRemoveElement(List<Integer> array, int i) {
        List<Integer> copy = new ArrayList<>(array);
        copy.remove(i);
        return copy;
    }

    /*Complexity: O(n*n!) time | O(n*n!) space */
    private static List<List<Integer>> getPermutationsOptimized(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutationsOptimizedHelper(0, array, permutations);
        return permutations;
    }

    private static void getPermutationsOptimizedHelper(int currentIndex, List<Integer> array, List<List<Integer>> permutations) {
        if (currentIndex == array.size() - 1) { // this is the base case -> means we have a permutation
            permutations.add(new ArrayList<>(array));
        } else {
            for (int i = currentIndex; i < array.size(); i++) {
                swap(array, currentIndex, i);
                getPermutationsOptimizedHelper(currentIndex + 1, array, permutations);
                swap(array, currentIndex, i);
            }
        }
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
