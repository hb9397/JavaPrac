package kakao.hb9397.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args){
        try(/*UDP 소켓 생성*/ DatagramSocket datagramSocket = new DatagramSocket(7001)){

            while(true){
                byte [] data = new byte[65536];

                // 데이터를 전송받을 패킷 클래스의 인스턴스 생성
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length);

                // 데이터 받기
                datagramSocket.receive(datagramPacket);

                // 클라이언트 정보 확인
                System.out.println(datagramPacket.getAddress());

                // 받은 msg 출력하는데 바이트 배열을 문자열로 바꾸기 때문에 공백을 제거해준다.
                System.out.println(new String(datagramPacket.getData()).trim());
            }

            // UDP는 연결할 소켓 없이 받아오는 DatagramSocket 만 있으면 된다.
            // 또한 try with resource catch 문을 사용해서 소켓을 따로 닫아줄 필요가 없다.

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }


    }
}
