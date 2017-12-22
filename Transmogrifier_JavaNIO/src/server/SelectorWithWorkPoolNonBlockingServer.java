package server;

import handlers.PooledReadHandler;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SelectorWithWorkPoolNonBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8080));
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        Map<SocketChannel, Queue<ByteBuffer>> pendingData = new ConcurrentHashMap<>();
        Queue<Runnable> selectorActions = new ConcurrentLinkedDeque<>();

        Handler<SelectionKey> acceptHandler = new AcceptHandler(pendingData);
        Handler<SelectionKey> readHandler = new PooledReadHandler(pool, selectorActions, pendingData);
        Handler<SelectionKey> writeHandler = new WriteHandler(pendingData);

        while (true) {
            selector.select();
            processSelectorActions(selectorActions);
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

    private static void processSelectorActions(Queue<Runnable> selectorActions) {
        Runnable action;
        while ((action = selectorActions.poll()) != null) {
            action.run();
        }
    }
}

