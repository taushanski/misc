package handlers;

import java.io.IOException;

public class PrintingHandler<S> extends DecoratedHandler<S> {

    public PrintingHandler(Handler other) {
        super(other);
    }

    @Override
    public void handle(S s) throws IOException {
        System.out.printf("Connected to socket %s%n", s);
        try {
            super.handle(s);
        } finally {
            System.out.printf("Disconnected from socket %s%n", s);
        }
    }
}
