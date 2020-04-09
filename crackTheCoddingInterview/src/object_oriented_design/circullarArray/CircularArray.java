package object_oriented_design.circullarArray;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
    private T[] items;
    private int head;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public T get(int index) {
        if (index < 0 || index >= items.length) {
            throw new ArrayIndexOutOfBoundsException("....");
        }
        return items[convert(index)];
    }

    public void set(int index, T item) {
        items[convert(index)] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }

    private class CircularArrayIterator<TI> implements Iterator<TI> {


        private final TI[] items;


        /* current reflects the offset from the rotated head, not from the actual
         * start of the raw array. */
        private int current = -1;

        public CircularArrayIterator(CircularArray<TI> circularArray) {
            this.items = circularArray.items;
        }


        @Override
        public boolean hasNext() {
            return current < items.length - 1;
        }

        @Override
        public TI next() {
            current++;
            TI item = (TI) items[convert(current)];
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
