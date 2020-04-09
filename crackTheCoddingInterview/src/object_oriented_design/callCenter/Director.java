package object_oriented_design.callCenter;

public class Director extends Employee {

    public Director(CallHandler handler) {
        super(handler);
        this.rank = Rank.Director;
    }
}
