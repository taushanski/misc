package object_oriented_design.jigsaw;

import java.util.HashMap;
import java.util.Map;

public class Piece {
    private Map<Orientation, Edge> edges = new HashMap<>();

    public void setEdgeAsOrientation(Edge edge, Orientation orientation) {
    }

    public void rotateEdgesBy(int numberOfRotations) {

    }

    public boolean isCorner() {
        return false;
    }

    public boolean isBorder() {
        return false;
    }


    public Edge getEdgeWithOrientation(Orientation orientationToMath) {
        return null;
    }

}
