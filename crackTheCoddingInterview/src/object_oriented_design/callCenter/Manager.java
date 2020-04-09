package object_oriented_design.callCenter;

public class Manager extends Employee {

    public Manager(CallHandler handler) {
        super(handler);
        this.rank = Rank.Manager;
    }
}
