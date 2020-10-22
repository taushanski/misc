package first_iteration.object_oriented_design.chatserver;

import java.util.List;

public abstract class Conversation {
    protected List<User> participants;
    protected int id;

    protected List<Message> messages;

    public List<Message> getMessages() {
        return null;
    }

    public boolean addMessage(Message m) {
        return false;
    }

    public int getid() {
        return 0;
    }

}
