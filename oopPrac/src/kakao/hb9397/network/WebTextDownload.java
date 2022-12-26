package kakao.hb9397.network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class WebTextDownload {
    public static void main(String[] args){
        try {
            // 카카오.com의 주소 정보 가져오기
            InetAddress ia = InetAddress.getByName("www.kakao.com");

            // 카카오에 연결하기 - 소켓 생성
            Socket socket = new Socket(ia, 443);

            //카카오에 요청을 전송할 수 있는 스트림을 생성한다.
            PrintWriter ps = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

            // 스트림으로 요청 전송
            ps.println("GET https://www.kakako.com");
            ps.flush();

            // 문자 단위로 전송을 받기 위한 스트림 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 여러 줄의 문자열을 하나로 만들기
            StringBuilder sb = new StringBuilder();
            while(true) {
                String imsi = br.readLine();
                if(imsi == null){
                    break;
                }

                sb.append(imsi + "\n");
            }
            String html = sb.toString();

            // Bad Request 발생 - 포트번호나 HTTP 메서드가 다를 가능성이 있기 때문에 다시 확인한다.

            // 사용한 자원 정리하기
            br.close();
            ps.close();
            socket.close();


            System.out.println(html);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
