package kakao.hb9397.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class ByteStreamMain {
    public static void main(String[] args){
        // 파일에 바이트 단위로 기록한다.
        // Java 8 부터는 람다식과 try ~ catch 문에서 아래의 내용 -> try with resource 문이 가능하다
        // ( ) 안에서 close() 가 필요한 인스턴스를 생성하면 다시 close를 선언하지 않아도 된다.
        // try ~ catch 블럭 밖에 선언하면 레거시 해지기 때문이고, try 절 안에서 생성하면 catch 절에서 사용할 수 없다.

        try(FileOutputStream fos = new FileOutputStream("C:\\InteliJ\\oopPrac\\sample.txt", true);){
            // 원래는 현재 경로보다는 따로 디렉토리를 만들어서 로그를 관리하는 것이 좋다.
            // appendMode 매개변수 자리에 true를 입력하면 내용을 추가할 수 있다.

            // 파일에 기록할 내용 만들기
            String msg = "Hello Stream";
            fos.write(msg.getBytes());
            fos.flush();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        // 파일을 내용을 바이트 단위로 읽어오는 바이트 스트림
        try(FileInputStream fis = new FileInputStream("C:\\InteliJ\\oopPrac\\sample.txt");){
            /*while(true){
                int x = fis.read();
                if(x == -1){ // 읽어온 데이터가 없으면 while 문 종료
                    break;
                }
                // 이렇게 되면 숫자로 출력된다.
                // System.out.println(x);

                System.out.println((char)x);*/
            while(true){
                // 읽을 수 있는 크기로 바이트 배열 생성
                byte [] b = new byte[fis.available()];
                int len = fis.read(b);

                if(len <= 0) {
                    System.out.println("읽은 데이터가 없음");
                    break;
                } else {
                    // 이렇게 되면 숫자 배열을 출력한다 - 텍스가 아닌 경우
                    System.out.println(Arrays.toString(b));

                    // 문자열로 변환해서 출력 - 텍스트인 경우
                    System.out.println(new String(b));
                }
            }
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
