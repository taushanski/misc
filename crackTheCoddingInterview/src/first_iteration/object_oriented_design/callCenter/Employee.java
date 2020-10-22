package first_iteration.object_oriented_design.callCenter;

public class Employee {
    private Call currentCall;
    protected Rank rank;

    public Employee(CallHandler handler) {

    }

    public void receiveCall(Call call) {
        this.currentCall = call;
    }

    /*the issue is resolved, finish the call*/
    public void callCompleted() {

    }

    /*The issue has not been resolved. Escalate the call, and assign a new call to
     *the employee.*/
    public void escalateAndReasign() {

    }

    public boolean assignNewCall() {
        return true;
    }

    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}
