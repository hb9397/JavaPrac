package kakao.hb9397.network;

import javax.swing.*;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args){
        try{
            // 접속할 컴퓨터의 IP 정보 가져오기
            InetAddress addr = InetAddress.getByName("192.168.0.38");

            Scanner scanner = new Scanner(System.in);
            while(true){
                // 접속할 컴퓨터(Server)의 IP와 접속 허용 포트번호를 매개변수로 받는 생성자로 연결
                Socket socket = new Socket(addr, 7000);

                // 문자열을 전홍하기 위한 스트림 생성
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

                // 문자열 전송
                /*printWriter.println("안녕하세요 !!!");
                printWriter.flush();*/


                System.out.print("메시지를 입력하세요 : ");
                String msg = scanner.nextLine();

                printWriter.println(msg);
                printWriter.flush();
                printWriter.close();
                socket.close();

                if(msg.equals("q")){
                    printWriter.close();
                    socket.close();
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
