package stack_queue_3;


public class StackWithMin2 extends MyStack<Integer> {

    private MyStack<Integer> mins;

    public StackWithMin2() {
        this.mins = new MyStack<>();
    }

    public void push(int value) {
        if (value <= min()) {
            mins.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        Integer value = super.pop();
        if (value == min()) {
            mins.pop();
        }
        return value;
    }

    private int min() {
        if (mins.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return mins.peek();
        }
    }

    public static class NodeWithMin {
        private int data;
        private int min;

        public NodeWithMin(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }
}

