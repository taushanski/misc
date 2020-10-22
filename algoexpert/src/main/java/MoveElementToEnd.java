import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        System.out.println("moveElementToEnd(array, 2) = " + moveElementToEnd(array, 2));
    }

    /*Complexity: O(n) time | O(1) space*/
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int swapIndex = array.size() - 1;
        int scanIndex = swapIndex - 1;
        while (scanIndex >= 0 && swapIndex >= 0) {
            if (array.get(swapIndex) == toMove) {
                swapIndex--;
                scanIndex = swapIndex - 1;
            } else if (array.get(scanIndex) == toMove) {
                int temp = array.set(swapIndex, array.get(scanIndex));
                array.set(scanIndex, temp);
                swapIndex--;
                scanIndex = swapIndex - 1;
            } else {
                scanIndex--;
            }
        }
        return array;
    }

}
