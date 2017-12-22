package handlers;

import handlers.Handler;
import util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;

public class ReadHandler implements Handler<SelectionKey> {
    private Map<SocketChannel, Queue<ByteBuffer>> pendingData;

    public ReadHandler(Map<SocketChannel, Queue<ByteBuffer>> pendingData) {
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
            System.out.printf("Disconnected from: %s (in read()) %n", sc);
        } else {
            Util.transmogrify(buffer);
            pendingData.get(sc).add(buffer);
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        }
    }
}
