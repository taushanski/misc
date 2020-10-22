package second_iteration.recursion_and_dinamic_programing_8;

public class MinProduct_8_5 {

    public static void main(String[] args) {
        int a = 7;
        int b = 8;
        System.out.println("minProduct(a, b) = " + minProduct(a, b));
    }

    static int minProduct(int a, int b) {
        int smaller = a < b ? a : b;
        int bigger = a < b ? b : a;
        return minProductHelper(smaller, bigger);
    }

    private static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) { // 0* bigger = 0
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        // we have to calculate the product of the half and double it if even otherwise compute the other side as well
        int s = smaller >> 1;// divide by 2
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, bigger);
        }
        return side1 + side2;

    }

}
