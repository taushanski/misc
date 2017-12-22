package handlers;

import java.io.IOException;

// Decorator pattern component
public interface Handler<S> {
    void handle(S s) throws IOException;
}
