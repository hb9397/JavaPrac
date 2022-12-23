package kakao.hb9397.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class BufferMain {
    public static void main(String[] args){
        // 버퍼 단위로 기록
        try(PrintStream ps = new PrintStream(new FileOutputStream("C:\\Users\\user\\Documents\\BufferTest.txt", true))){
            String msg = "안녕하세요 버퍼 스트림";

            // write 바이트 단위 기록
            ps.write(msg.getBytes());

            // print는 문자열을 스스로 바이트로 변환해서 기록한다.
            ps.print(msg);
            ps.flush();
        }catch(Exception e) {
            e.getLocalizedMessage();
        }

        // 버퍼 단위로 읽기
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\user\\Documents\\BufferTest.txt"))){
            /*while(true){
                // 파일에서 읽을 수 있는 크기로 바이트 배열을 생성한다.
                byte [] b = new byte[bis.available()];

                // 읽어오기
                int len = bis.read(b);

                // 읽은 것이 없으면 종료
                if(len <= 0){
                    break;
                }
                System.out.println(Arrays.toString(b));
                // 읽어온 데이터 문자열로 변환
                System.out.println(new String(b));

            }*/

            // 파일에서 읽을 수 있는 크기로 바이트 배열 생성
            /*byte [] b = new byte[bis.available()];
            while(bis.read(b) > 0){
                System.out.println(Arrays.toString(b));

                // 문자열로 변환
                System.out.println(new String(b));*/

            // 나눠서 읽기 - 웹에서 파일 다운로드 받을 때 사용하는 방식
            while(true){
                // 16 바이트 단위로 읽어오기
                // 웹에서 1024 비트 약 128 바이트의 패킷으로 통신하기 때문에 일반적으로는 128 또는 128의 배수를 많이 사용한다.
                // byte [] b = new byte[16];

                // 버퍼의 출력단위가 매우 큰 경우
                byte [] b = new byte[1024];
                int len = bis.read(b, 0, b.length);
                if(len <= 0){
                    break;
                }
                // 받을 내용을 가지고 작업하는데 다운로드라면 파일에 기록하고 문자열이라고 하면 하나로 모아서 읽어야 한다.
                // 위 의 두 while 문에서는 한번에 받아서 읽기 때문에 깨지지 않지만 한글은 2바이트 혹은 3바이트로 기록되기 때문에 깨지게 된다.
                // 그래서 파일 입/출력에서는 인코딩, 디코딩을 그리고 버퍼의 입력 단위 버퍼의 출력 단위를 신경 써야 한다.
                System.out.println(new String(b));

                // 문자열인 경우에는 입력 버퍼나 출력 버퍼의 단위가 클 수 도 있기 때문에 trim()메서드로 좌우 공백을 제거하고 출력해야 한다.
                System.out.println((new String(b)).trim());
            }
        } catch (Exception e){
           System.out.println(e.getLocalizedMessage());
        }
    }
}
