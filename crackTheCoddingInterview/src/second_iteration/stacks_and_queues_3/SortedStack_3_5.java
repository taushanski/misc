package second_iteration.stacks_and_queues_3;

import java.util.Stack;

public class SortedStack_3_5<T extends Comparable<T>> {

    private Stack<T> sortedStack;

    private Stack<T> helperStack;

    public SortedStack_3_5() {
        this.sortedStack = new Stack<>();
        this.helperStack = new Stack<>();
    }

    public void push(T element) {
        moveSmallerItems(element);
        sortedStack.push(element);
        moveBackSmallerItems();
    }

    private void moveSmallerItems(T element) {
        while (!sortedStack.empty() && sortedStack.peek().compareTo(element) < 0) {
            helperStack.push(sortedStack.pop());
        }
    }

    private void moveBackSmallerItems() {
        while (!helperStack.empty()) {
            sortedStack.push(helperStack.pop());
        }
    }

    public T pop() {
        return sortedStack.pop();
    }

    public static void main(String[] args) {
        SortedStack_3_5<Integer> stack = new SortedStack_3_5<>();
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(4);
        System.out.println("printStack(stack) = " + stack.print());

    }

    private String print() {
        return sortedStack.toString();
    }

}
