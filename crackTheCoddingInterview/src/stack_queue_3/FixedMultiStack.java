package stack_queue_3;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private final int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        this.stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /**
     * Push value in the stack with the given id
     *
     * @param stackNumber
     * @param value
     */
    public void push(int stackNumber, int value) throws FullStackException {
        // check that there is enough space in the stack
        if (isFull(stackNumber)) {
            throw new FullStackException();
        }
        sizes[stackNumber]++;
        values[indexOfTop(stackNumber)] = value;
    }

    private boolean isFull(int stackNumber) {
        return sizes[stackNumber] >= stackCapacity;
    }

    private int indexOfTop(int stackNumber) {
        int offset = stackNumber * stackCapacity;
        int currentStackSize = sizes[stackNumber];
        return offset + currentStackSize - 1;
    }

    public int pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNumber);
        int value = values[topIndex];
        values[topIndex] = 0; //
        sizes[stackNumber]--;
        return value;
    }

    private boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    public int peek(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNumber)];
    }


    public static class FullStackException extends Exception {
    }
}

