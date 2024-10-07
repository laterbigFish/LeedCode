package MyUDP;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class MyUdpEcchoClint {
    private DatagramSocket socket = null;
    private String IP;
    private int port;

    public MyUdpEcchoClint(DatagramSocket socket, String IP, int port) throws SocketException {
        this.socket = new DatagramSocket();
        this.IP = IP;
        this.port = port;
    }
    //服务器和客户端恰好相反

    public void start(){
        System.out.println("启动客户端");
        Scanner scanner = new Scanner(System.in);

        while(true){

        }
    }
}
