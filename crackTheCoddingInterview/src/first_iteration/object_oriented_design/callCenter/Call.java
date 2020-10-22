package first_iteration.object_oriented_design.callCenter;

public class Call {

    /*Minimal rank of employee who can handle this call*/
    private Rank rank;

    private final Caller caller;
    /*employee handling the call*/
    private Employee handler;

    public Call(Caller caller) {
        rank = Rank.Responder;
        this.caller = caller;
    }

    public void setHandler(Employee employee) {
        this.handler = employee;
    }

    public void reply(String s) {
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank incrementRank() {
        return null;
    }

    public void disconnect() {

    }
}
