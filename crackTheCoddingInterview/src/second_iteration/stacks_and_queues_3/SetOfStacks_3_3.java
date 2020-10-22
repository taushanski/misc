package second_iteration.stacks_and_queues_3;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks_3_3 {

    private static class SetOfStacks<T> {


        private final int threshold;

        private List<Stack<T>> stacks;


        public SetOfStacks(int threshold) {
            this.threshold = threshold;
        }

        public void push(T element) {
            Stack<T> stack = getStackWithCapacity();
            stack.push(element);
        }

        private Stack<T> getStackWithCapacity() {
            ensureStackCapacity();
            Stack<T> lastStack = getLastStack();
            return lastStack;
        }

        private void ensureStackCapacity() {
            Stack<T> lastStack = getLastStack();
            if (lastStack.size() >= threshold) { // the stack is full so we have to create a new one
                lastStack = new Stack<>();
                stacks.add(lastStack);
            }

        }

        private Stack<T> getLastStack() {
            if (stacks.size() == 0) {
                return null;
            }
            return stacks.get(stacks.size() - 1);
        }

        public T pop() {
            Stack<T> lastStack = getLastStack();
            if (lastStack == null) {
                throw new EmptyStackException();
            }

            T pop = lastStack.pop();
            if (lastStack.isEmpty()) {
                removeLastStack();
            }
            return pop;
        }

        private void removeLastStack() {
            if (stacks.size() > 0) {
                stacks.remove(stacks.size() - 1);
            }
        }


    }

}
