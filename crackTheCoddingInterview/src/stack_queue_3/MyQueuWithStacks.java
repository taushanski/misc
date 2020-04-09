package stack_queue_3;

import java.util.Stack;

public class MyQueuWithStacks<T> {

    private Stack<T> stackNewest;
    private Stack<T> stackOldest;

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T element) {
        stackNewest.push(element);
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}
