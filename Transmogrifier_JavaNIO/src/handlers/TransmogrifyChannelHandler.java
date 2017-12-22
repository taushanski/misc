package handlers;

import util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TransmogrifyChannelHandler implements Handler<SocketChannel> {
    @Override
    public void handle(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(80);
        int read = socketChannel.read(buffer);
        if (read == -1) {
            socketChannel.close();
            return;
        } else if (read > 0) {
            Util.transmogrify(buffer);
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.compact();
        }


    }
}
