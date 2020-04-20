package ClientReceiver;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
public class ReceiveDataFromServer {
    private DatagramSocket ds = new DatagramSocket(55665);
    public ReceiveDataFromServer() throws SocketException {
    }
    public void receive() throws IOException {
            byte[] buf = new byte[16384];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            ds.receive(packet);
            ds.close();
            String data = new String(buf, StandardCharsets.UTF_8);
            System.out.println(data);
    }
}
