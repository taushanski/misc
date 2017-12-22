package util;

import java.nio.ByteBuffer;

public class Util {
    public static int transmogrify(int read) {
        return Character.isLetter(read) ? read ^ ' ' : read;
    }

    public static void transmogrify(ByteBuffer buffer) {
        System.out.printf("Transmogrification done by %s%n", Thread.currentThread());
        buffer.flip();
        for (int i = 0; i < buffer.limit(); i++) {
            buffer.put(i, (byte) transmogrify(buffer.get(i)));
        }
    }
}
