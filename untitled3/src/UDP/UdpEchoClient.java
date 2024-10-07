package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    public UdpEchoClient(String serverIP, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("启动客户端");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1. 从控制台读取到用户的输入.
            System.out.print("-> ");
            String request = scanner.next();
            // 2. 构造出一个 UDP 请求, 发送给服务器.
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(this.serverIP), this.serverPort);
            socket.send(requestPacket);
            // 3. 从服务器读取到响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            // 4. 把响应打印到控制台上.
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        // UdpEchoClient client = new UdpEchoClient("47.108.28.88", 9090);
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
