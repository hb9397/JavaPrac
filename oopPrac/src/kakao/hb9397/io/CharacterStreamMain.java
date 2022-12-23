package kakao.hb9397.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CharacterStreamMain {
    public static void main(String[] main){
        // 오늘 날짜로 파일명 생성 : 2022-12-23.log
        // 디렉토리 경로 생성
        String directory = "C:\\Users\\user\\Documents\\";

        // 오늘 날짜 문자열 만들기
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String filename = sdf.format(date);

        // 문자열 더하기 연산은 메모리 누수의 원인
        // String path = directory + filename + ".log";

        // 파일 경로 String.format으로 지정
        String path = String.format("%s%s%s", directory, filename, ".log");

        // 문자 단위로 버퍼를 이용해서 기록하기
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))){
            pw.println("안녕하세요");
            pw.println("반갑습니다.");
            pw.println("1234");

            // Stream 입력(wirte)시 항상 flush를 해주는 것이 좋다.
            pw.flush();
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        // 문자 단위로 읽어오기
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            while(true){
                String str = br.readLine();

                // 읽은 데이터 없으면 종료
                // readLine은 String을 반환하고 읽을 줄이 없으면 null을 반환한다.
                if(str == null) {
                    break;
                }
                System.out.println(str);

                // 숫자가 아닌 문자열을 숫자로 변환하면 NumverFormatException이 발생한다.
                // Web에서 파라미터는 무조건 문자열인데 파라미터를 숫자로 변환하는 경우 발생 가능한 예외 이다.
                System.out.println(Integer.parseInt(str));
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            // 발생한 예외를 확인하려면 아래 코드를 입력하면 된다.
            // e.printStackTrace();
        }
    }
}
