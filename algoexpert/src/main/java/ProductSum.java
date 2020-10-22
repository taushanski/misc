import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> specialArray = new ArrayList<>();
        specialArray.add(5);
        specialArray.add(2);
        specialArray.add(Arrays.asList(7, -1));
        specialArray.add(3);
        specialArray.add(Arrays.asList(6, Arrays.asList(-13, 8), 4));


        System.out.println("productSum(specialArray) = " + productSum(specialArray));

    }

    /*Complexity: O(d) space where d is the max depth | O()*/
    private static int productSum(List<Object> specialArray) {
        return productSumNestedArray(specialArray, 1);
    }

    private static int productSumNestedArray(List<Object> specialArray, int depth) {
        int sum = 0;
        for (Object nextElement : specialArray) {
            if (nextElement instanceof List) {
                sum += productSumNestedArray((List<Object>) nextElement, depth + 1);
            } else {
                sum += (int) nextElement;
            }
        }
        return depth * sum;
    }
}
