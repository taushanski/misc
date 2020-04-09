package object_oriented_design.chatserver;

import java.util.Map;

/*
Serves as a central component for core user management
 */
public class UserManagement {

    private static UserManagement instance;

    private Map<Integer, User> usersById;

    private Map<String, User> usersByAccountName;

    private Map<Integer, User> onlineUsers;


    public static UserManagement getInstance() {
        if (instance == null) {
            instance = new UserManagement();
        }
        return instance;
    }

    public void addUser(User fromUser, String toAccountName) {
        User targetUser = usersByAccountName.get(toAccountName);
        AddRequest addRequest = new AddRequest(fromUser, targetUser);
        fromUser.sendAddRequest(addRequest);
        targetUser.receivedAddRequest(addRequest);

    }

    public void approveAddRequest(AddRequest req) {
    }

    public void rejectAddRequest(AddRequest req) {
    }

    public void userSignedOn(String accountName) {
    }

    public void userSignedOff(String accountName) {
    }
}
