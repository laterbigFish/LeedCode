package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    // 通过 start 启动服务器的核心流程
    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true) {
            // 此处通过 "死循环" 不停的处理客户端的请求.
            // 1. 读取客户端的请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            // 上述收到的数据, 是二进制 byte[] 的形式体现的. 后续代码如果要进行打印之类的处理操作
            // 需要转成字符串才好处理.
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            // 2. 根据请求计算响应, 由于此处是回显服务器. 响应就是请求.
            String response = process(request);
            // 3. 把响应写回到客户端                                                  这里要的是字节数
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);

            // 4. 把日志打印一下.
            System.out.printf("[%s:%d] req=%s, resp=%s\n", requestPacket.getAddress(), requestPacket.getPort(),
                    request, response);
        }
    }
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
