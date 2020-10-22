package first_iteration.sorting_and_serching;

public class RotatedArraySearch_10_3 {


    /*This code will run in O(log n) if all the elements are unique. However, with many duplicates,
     * the algorithm is actually O( n). This is because with many duplicates, we will often have to
     * search both the left and right sides of the array (or sub-arrays).
     * Note that while this problem is not conceptually very complex, it is actually very difficult to implement flaw­ lessly.
     * Don't feel bad if you had trouble implementing it without a few bugs.
     * Because of the ease of making off-by-one and other minor errors, you should make sure to test your code very thoroughly.
     */
    public static int search(int[] a, int left, int right, int x) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (a[mid] == x) {
            return mid;// found element
        }

        /*Either the left or right half must be normally ordered. Find out which side
         * is normally ordered, and then use the normally ordered half to figure out
         * which side to search to find x.*/

        if (a[left] < a[mid]) { // the left side is ordered normally
            if (x >= a[left] && x < a[mid]) { // search left
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x); // search right
            }
        } else if (a[left] > a[mid]) { // the right side is ordered normally
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x); // search right
            } else {
                return search(a, left, mid - 1, x); // search left
            }
        } else if (a[left] == a[mid]) { // Left or right half is all repeats
            if (a[mid] != a[right]) { // the right is different
                return search(a, mid + 1, right, x);
            } else { // we have to search both halves
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }

            }

        }
        return -1;
    }
}
