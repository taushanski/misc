package first_iteration.stack_queue_3;

import java.util.Stack;

public class SortStack {

    public void sort(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();
        while (!stack.isEmpty()) {
            // insert each element in sorted order in sortedStack
            int temp = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        // copy elements back ito stack
        while (!sortedStack.isEmpty()) {
            stack.push(sortedStack.pop());
        }
    }
}
