package stack_queue_3;


public class StackWithMin extends MyStack<StackWithMin.NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    private int min() {
        if (isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
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

