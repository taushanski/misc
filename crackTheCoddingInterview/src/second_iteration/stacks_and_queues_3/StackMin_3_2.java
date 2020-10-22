package second_iteration.stacks_and_queues_3;

public class StackMin_3_2<T> {

    private static class StackWithMin1 extends MyStack<StackWithMin1.StackNodeWithMin> {

        public void push(int data) {
            int newMin = Math.min(data, min());
            super.push(new StackNodeWithMin(data, newMin));
        }

        public int pop2() {
            return super.pop().value;
        }

        private int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }

        private static class StackNodeWithMin {

            private int value;

            private int min;

            public StackNodeWithMin(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }


    }


}
