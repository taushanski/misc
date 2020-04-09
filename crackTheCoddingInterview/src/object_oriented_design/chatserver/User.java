package object_oriented_design.chatserver;

import java.util.List;
import java.util.Map;

public class User {
    private int id;

    private UserStatus userStatus;

    /* maps from the other participant's user id to the chat */
    private Map<Integer, PrivateChat> privateChats;

    /* list of group chats */
    private List<GroupChat> groupChats;


    /* maps from the other person's user id to the add request */
    private Map<Integer, AddRequest> receivedAddRequests;

    /* maps from the other person's user id to the add request */
    private Map<Integer, AddRequest> sentAddRequests;

    /* maps from the user id to user object */
    private Map<Integer, User> contacts;

    private String accountName;

    private String fullName;

    public User(int id, String accountName, String fullName) {
        this.id = id;
        this.accountName = accountName;
        this.fullName = fullName;
    }

    public boolean sendMessageToUser(User to, String content) {
        return false;
    }

    public boolean sendMessageToGroupChat(int id, String cnt) {
        return false;
    }

    public void setStatus(UserStatus status) {
    }

    public UserStatus getStatus() {
        return null;
    }

    public boolean addContact(User user) {
        return false;
    }

    public void sentAddRequest(AddRequest req) {
    }

    public void removeAddRequest(AddRequest req) {
    }

    public void addConversation(PrivateChat conversation) {
    }

    public void addConversation(GroupChat conversation) {
    }

    public int getid() {
        return 0;
    }

    public String getAccountName() {
        return null;
    }

    public String getFullName() {
        return null;
    }

    public void receivedAddRequest(AddRequest addRequest) {
        UserManagement.getInstance().approveAddRequest(addRequest);
    }

    public void requestAddUser(String accountName) {
        UserManagement.getInstance().addUser(this, accountName);
    }

    public void sendAddRequest(AddRequest addRequest) {
    }
}
