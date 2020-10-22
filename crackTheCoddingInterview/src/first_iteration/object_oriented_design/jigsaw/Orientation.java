package first_iteration.object_oriented_design.jigsaw;

public enum Orientation {
    /*should stay in this order*/
    LEFT,
    TOP,
    RIGHT,
    BOTTOM;

    public Orientation getOpposite() {
        switch (this) {
            case LEFT:
                return RIGHT;
            case TOP:
                return BOTTOM;
            case RIGHT:
                return LEFT;
            case BOTTOM:
                return TOP;
            default:
                return null;
        }
    }
}
