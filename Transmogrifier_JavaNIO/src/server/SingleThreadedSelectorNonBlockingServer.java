package server;

import handlers.ReadHandler;
import handlers.WriteHandler;
import handlers.AcceptHandler;
import handlers.Handler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class SingleThreadedSelectorNonBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8080));
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);


        Map<SocketChannel, Queue<ByteBuffer>> pendingData = new HashMap<>();

        Handler<SelectionKey> acceptHandler = new AcceptHandler(pendingData);
        Handler<SelectionKey> readHandler = new ReadHandler(pendingData);
        Handler<SelectionKey> writeHandler = new WriteHandler(pendingData);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (Iterator<SelectionKey> it = selectionKeys.iterator(); it.hasNext(); ) {
                SelectionKey nextKey = it.next();
                it.remove();
                if (nextKey.isValid()) {
                    if (nextKey.isAcceptable()) {
                        acceptHandler.handle(nextKey);
                    } else if (nextKey.isReadable()) {
                        readHandler.handle(nextKey);
                    } else if (nextKey.isWritable()) {
                        writeHandler.handle(nextKey);
                    }
                }
            }
        }
    }
}

