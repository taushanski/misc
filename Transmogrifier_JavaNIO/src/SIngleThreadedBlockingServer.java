import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SIngleThreadedBlockingServer {
    public SIngleThreadedBlockingServer() {
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket socket = ss.accept(); // Never null
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            int read;
            while ((read = in.read()) != -1) {
                out.write(transmogrify(read));

            }
//            in.transferTo(out);

            in.close();
            out.close();
            socket.close();
        }

    }

    private static int transmogrify(int read) {
        return Character.isLetter(read) ? read ^ ' ' : read;
    }
}
