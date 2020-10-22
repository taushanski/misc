package first_iteration.dynamic_programing_and_recursion;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StackOfBoxes {


    private static int createStack(List<Box> boxes) {
        /*Sort in descending order the boxes by height*/
        Collections.sort(boxes, Comparator.<Box>comparingInt(box -> box.height).reversed());

        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, stackMap);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;


    }

    private static int createStack(List<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i, stackMap);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottom.height;
        stackMap[bottomIndex] = maxHeight;
        return maxHeight;
    }


    private static class Box {
        private int height;
        private int width;
        private int depth;

        public boolean canBeAbove(Box other) {
            return this.height < other.height && this.width < other.width && this.depth < other.depth;
        }
    }
}
