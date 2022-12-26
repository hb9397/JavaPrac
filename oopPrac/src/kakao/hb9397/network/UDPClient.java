package kakao.hb9397.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args){
        try{ // 보내야 하는 IP주소와 Port 번호 설정을 위해서 Try with resource 절 불가

            // 보낼 데이터 입력
            Scanner scanner = new Scanner(System.in);
            InetAddress addr = InetAddress.getByName("192.168.0.38");
            while(true){

                System.out.print("보낼 메시지를 입력하세요: ");
                String msg = scanner.nextLine();
                // 소켓 생성
                DatagramSocket socket = new DatagramSocket();

                // 보내는 패킷 생성
                DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, 7001);

                // 데이터 전송
                socket.send(datagramPacket);

                socket.close();
            }

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
