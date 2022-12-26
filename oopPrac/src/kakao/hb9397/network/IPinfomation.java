package kakao.hb9397.network;

import java.net.InetAddress;
import java.util.Arrays;

public class IPinfomation {
    public static void main(String[] args){
        try{
            // 자신의 컴퓨터의 IP 정보를 확인한다.
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);

            // 도메인을 가지고 IP 정보를 확인한다.
            // 하나의 사이트 도메인에 여러개의 IP가 존재할 수 있다.
            InetAddress [] naver = InetAddress.getAllByName("www.naver.com");
            System.out.println(Arrays.toString(naver));

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());

            // 오늘 날짜로 텍스트 파일을 생성해서 예외를 기록하는 연습

        }
    }
}
