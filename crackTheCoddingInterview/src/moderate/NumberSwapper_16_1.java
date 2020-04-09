package moderate;

public class NumberSwapper_16_1 {

    public static void main(String[] args) {
        swapWithoutTempVariables(20, 2);
        swapWithoutTempVariables(2, 20);

        swapWithoutTempVariablesWithXor(20, 2);
        swapWithoutTempVariablesWithXor(2, 20);
    }

    private static void swapWithoutTempVariables(int left, int right) {
        System.out.printf("The input variables are left=%d, right=%d%n", left, right);

        if (left > right) {
            left = left - right; // diff
            right = right + left; // right + left - right => left
            left = right - left; // right + left - right + right -left
        } else {
            right = right - left; // diff
            left = left + right; // left + right -left =? right
            right = left - right; // right - right + left

        }

        System.out.printf("The output variables are left=%d, right=%d%n", left, right);
    }

    private static void swapWithoutTempVariablesWithXor(int left, int right) {
        System.out.printf("The input variables are left=%d, right=%d%n", left, right);
        left = left ^ right;
        right = left ^ right;
        left = left ^ right;

        System.out.printf("The output variables are left=%d, right=%d%n", left, right);
    }
}
