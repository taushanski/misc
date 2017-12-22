package server;

import handlers.Handler;
import handlers.PrintingHandler;
import handlers.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080, 3);

        Handler handler = new PrintingHandler<Socket>(
                new TransmogrifyHandler()
        );
        while (true) {
            Socket socket = ss.accept();
            handler.handle(socket);
        }
    }

}
