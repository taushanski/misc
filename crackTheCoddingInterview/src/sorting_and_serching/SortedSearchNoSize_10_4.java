package sorting_and_serching;

import java.util.Arrays;

public class SortedSearchNoSize_10_4 {

    public static void main(String[] args) {
        Listy listy = new Listy(500);
        for (int i = 0; i < 1000; i += 2) {
            listy.add(i);
        }
        System.out.println("listy = " + listy);
        int searchFor = 500;

        long startTime = System.currentTimeMillis();
        System.out.printf("find Element linear search=%d%n", findElement(searchFor, listy));
        System.out.printf("Linear search executed for: %d%n", (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.printf("findElement BinarySearch=%d%n", findElementBinarySearch(searchFor, listy));
        System.out.printf("Binary search executed for: %d%n", (System.currentTimeMillis() - startTime));
    }

    // The runtime is O(n)
    private static int findElement(int x, Listy listy) {
        for (int i = 0, nextElement = -1; (nextElement = listy.elementAt(i)) >= 0; i++) {
            if (nextElement == x) {
                return i;
            }
        }
        return -1;
    }

    // O(log n + log n) = O(2log n) = O(log n)
    private static int findElementBinarySearch(int x, Listy listy) {
        int size = getSize(listy, x);

        return findElementBinarySearch(x, listy, size / 2, size);

    }

    // time complexity is O(log n)
    private static int getSize(Listy listy, int value) {
        int index = 1;
        while (listy.elementAt(index) != -1 && listy.elementAt(index) < value) {
            // we stop at the moment when: elementAt(index/2)<=value< elementAt(index)
            index *= 2;
        }
        return index;
    }

    // runtime is O(log n)
    private static int findElementBinarySearch(int x, Listy listy, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (listy.elementAt(middle) == x) { // found it
            return middle;
        } else if (listy.elementAt(middle) < x) { // its in the right side
            return findElementBinarySearch(x, listy, middle + 1, right);
        } else if (listy.elementAt(middle) > x || listy.elementAt(middle) == -1) { // its in the left part >x
            return findElementBinarySearch(x, listy, left, middle - 1);
        }
        return -1;
    }


    public static class Listy {
        private int[] elements;
        private int currentIndex;

        public Listy(int size) {
            this.elements = new int[size];
        }

        public Listy add(int element) {
            if (element < 0) {
                throw new IllegalArgumentException("Negative values are not allowed");
            }
            elements[currentIndex] = element;
            currentIndex++;
            return this;
        }

        public int elementAt(int index) {
            if (index < 0 || index >= elements.length) {
                return -1;// out of bounds
            }
            return elements[index];
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Listy{");
            sb.append("elements=").append(Arrays.toString(elements));
            sb.append('}');
            return sb.toString();
        }
    }
}
