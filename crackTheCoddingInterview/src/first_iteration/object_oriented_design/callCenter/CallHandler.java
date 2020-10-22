package first_iteration.object_oriented_design.callCenter;

import java.util.List;

public class CallHandler {
    // levels of employees: respondents, managers, directors
    private final int LEVELS = 3;

    /*
     * List of employees by levels
     * employeeLevels[0] = respondents
     * employeeLevels[1] = managers
     * employeeLevels[2] = directors
     */ List<List<Employee>> employeeLevels;


    // queues for each call;s rank
    List<List<Call>> callQueues;

    public CallHandler() {
    }

    /*Gets the first available employee who can handle this call*/
    public Employee getHandlerForCall(Call call) {
        return null;
    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    /*Routes the call to an available employee, or saves in a queue if no employee * is available.*/
    private void dispatchCall(Call call) {
        Employee employee = getHandlerForCall(call);
        if (employee != null) {
            employee.receiveCall(call);
            call.setHandler(employee);
        } else {
            /* Place the call into corresponding call queue according to its rank. */
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    /*   An employee     got free.Look for    a waiting    call that    employee can    serve.
    Return true if we assigned a call, false otherwise .*/

    public boolean assignCall(Employee emp) {
        return true;
    }
}
