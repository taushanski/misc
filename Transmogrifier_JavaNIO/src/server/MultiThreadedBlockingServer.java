package server;

import handlers.Handler;
import handlers.PrintingHandler;
import handlers.ThreadedHandler;
import handlers.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Handler<Socket> handler = new ThreadedHandler<>(
                new PrintingHandler<>(
                        new TransmogrifyHandler()
                )
        );

        while (true) {
            Socket socket = ss.accept();
            handler.handle(socket);
        }

    }

}
