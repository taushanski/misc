package second_iteration.stacks_and_queues_3;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueViaStacks_3_4<T> {

    public static void main(String[] args) {
        QueueViaStacks_3_4<Integer> queue = new QueueViaStacks_3_4();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    private Stack<T> tailElements;

    private Stack<T> headElements;

    public QueueViaStacks_3_4() {
        tailElements = new Stack<>();
        headElements = new Stack<>();
    }

    // O(1)
    public void add(T element) {
        tailElements.push(element);
    }

    // the amortized time is O(1). Every once in a while we will have to copy the elements from tailElements stack but
    // after that for n removals we won't have to copy the elements so n romvals takes O(n) which means 1 removal
    // will takee O(1)
    public T remove() {
        moveTailElementsIfNecessary();
        if (headElements.empty()) {
            throw new NoSuchElementException();
        }
        return headElements.pop();
    }

    private void moveTailElementsIfNecessary() {
        if (headElements.empty() && !tailElements.empty()) {
            while (!tailElements.empty()) {
                headElements.push(tailElements.pop());
            }
        }
    }
}
