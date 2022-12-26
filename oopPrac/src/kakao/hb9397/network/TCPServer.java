package kakao.hb9397.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] main){
        try{
            ServerSocket serverSocket = new ServerSocket(7000);

            while(true){
                System.out.println("서버 대기 중");
                // 클라이언트 요청이전 까지 블락시키는 메서드 호출
                Socket socket = serverSocket.accept();

                // 접속한 클라이언트 정보 확인하기
                System.out.println(socket);

                // 클라이언트가 전송한 내용 읽어오기
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 한줄의 메시지 씩 읽어오기
                String msg = br.readLine();
                System.out.println(msg);

                // Socket과 BufferedReader 정리
                br.close();
                socket.close();


            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
