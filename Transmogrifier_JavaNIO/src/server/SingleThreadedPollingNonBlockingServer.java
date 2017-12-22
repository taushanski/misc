package server;

import handlers.Handler;
import handlers.TransmogrifyChannelHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;

public class SingleThreadedPollingNonBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8080));
        ssc.configureBlocking(false);


        Handler<SocketChannel> handler = new TransmogrifyChannelHandler();
        Collection<SocketChannel> sockets = new ArrayList<>();
        while (true) {
            SocketChannel socket = ssc.accept();
            if (socket != null) {
                sockets.add(socket);
                System.out.println("Connected to: " + socket);
                socket.configureBlocking(false);
            }

            for (SocketChannel nextChannel : sockets) {
                if (nextChannel.isConnected()) {
                    handler.handle(nextChannel);
                }
            }

            sockets.removeIf(socketChannel -> !socketChannel.isConnected());
        }

    }

}
