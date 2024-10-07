package MyUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyUdpEchoSever {
       private DatagramSocket socket = null;
       public MyUdpEchoSever(int poor) throws SocketException {
           socket = new DatagramSocket(poor);
       }
       public void start() throws IOException {
           System.out.println("服务器启动");

           while(true){
               //接收服务端的信息
               DatagramPacket packet = new DatagramPacket(new byte[4096],4096);

               socket.receive(packet);
               //将客户端信息转化为字符串
               String str = new String(packet.getData(),0,packet.getLength());

               //响应
               String revice =  process(str);
               //将响应发送给客户端  由于UDP是无连接的因此不保留对端的信息
               DatagramPacket revecePacket = new DatagramPacket(revice.getBytes(),revice.getBytes().length,packet.getSocketAddress());
               socket.send(revecePacket);
           }
       }

    private String process(String str) {
           return str;
    }

    public static void main(String[] args) throws SocketException {
        MyUdpEchoSever sever = new MyUdpEchoSever(9090);
    }
}
