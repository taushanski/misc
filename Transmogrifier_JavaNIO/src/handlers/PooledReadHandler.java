package handlers;

import util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class PooledReadHandler implements Handler<SelectionKey> {
    private final ExecutorService pool;
    private final Queue<Runnable> selectorActions;
    private final Map<SocketChannel, Queue<ByteBuffer>> pendingData;

    public PooledReadHandler(ExecutorService pool, Queue<Runnable> selectorActions, Map<SocketChannel, Queue<ByteBuffer>> pendingData) {

        this.pool = pool;
        this.selectorActions = selectorActions;
        this.pendingData = pendingData;
    }

    @Override
    public void handle(SelectionKey selectionKey) throws IOException {
        SocketChannel sc = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(80);
        int read = sc.read(buffer);
        if (read == -1) {
            pendingData.remove(sc);
            sc.close();
            System.out.printf("Disconnected from: %s (in pooled read()) %n", sc);
        } else {
            pool.submit(() -> {
                Util.transmogrify(buffer);
                pendingData.get(sc).add(buffer);
                selectorActions.add(() -> selectionKey.interestOps(SelectionKey.OP_WRITE));
                selectionKey.selector().wakeup();
            });
        }
    }
}
