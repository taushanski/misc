package first_iteration.object_oriented_design.jigsaw;

public enum Shape {
    INNER,
    OUTER,
    FLAT;

    public Shape getOpposite() {
        switch (this) {
            case INNER:
                return OUTER;
            case OUTER:
                return INNER;
            default:
                return null;
        }
    }
}
