package server;

import handlers.ExecutorServiceHandler;
import handlers.Handler;
import handlers.PrintingHandler;
import handlers.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class ExecutorServiceBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Handler<Socket> handler = new ExecutorServiceHandler<>(
                new PrintingHandler<>(
                        new TransmogrifyHandler()
                ), Executors.newFixedThreadPool(10)
        );

        while (true) {
            Socket socket = ss.accept();
            handler.handle(socket);
        }

    }

}
