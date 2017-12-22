package handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static util.Util.transmogrify;

public class TransmogrifyHandler implements Handler<Socket> {

    @Override
    public void handle(Socket socket) throws IOException {
        try (
                socket; // Java 9
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
        ) {

            int read;
            while ((read = in.read()) != -1) {
                if(read == '%') throw new IOException("Oopsi");
                out.write(transmogrify(read));

            }
        }

    }
}
