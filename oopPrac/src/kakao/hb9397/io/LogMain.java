package kakao.hb9397.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LogMain {
    public static void main(String [] args){
        // 파일 경로 확인
        File file = new File("log.txt");
        System.out.println(file.exists());

        // 문자열을 읽기 위한 스트림 생성
        try(BufferedReader br = new BufferedReader(new FileReader("log.txt"))){
            // 트래픽의 합계를 구할 변수 생성
            int sumTraffic = 0;

            // 줄단위로 읽어서 log.txt 출력하기
            while(true){
                String log = br.readLine();

                // 더이상 읽을 line 이 없다면 종료
                if(log == null){
                    break;
                }

                // 읽을 데이터가 남아있다면 줄단위로 출력
                // System.out.println(log);

                // 공백을 기준으로 분할해서 배열에 저장
                String [] ar = log.split(" ");

                // 공백을 기준으로 나눈 첫번째 요소는 IP
                // System.out.println(ar[0]);

                // 맨 마지막 요소로 접근하는 것은 배열이름[배열이름.length-1]로 접근
                // log.txt 맨 마지막 요소는 트래픽
                // System.out.println(ar[ar.length-1]);

                // 트래픽 합 구하기
                // sumTraffic = sumTraffic + Integer.parseInt(ar[ar.length-1]);

                // 한 번씩 바로 출력하면 log.txt 각 줄을 공백으로 나눈 맨 마지막 요소에 - 가 몇개 포함 되어있기 때문에 에러가 발생한다.
                // 합계 역시 구할 수 없다.
                // System.out.println(sumTraffic);

                // 예외 발생해도 생략하고 트래픽을 정수로 변환해서 더하기
                try{
                    // 문자열을 정수로 변환해서 더할 때 예외가 발생해도 넘어가기 위해서
                    // try~catch 사용
                    sumTraffic = sumTraffic + Integer.parseInt(ar[ar.length-1]);
                } catch (Exception e){}
            }
            System.out.println("Traffic 총 합: " + sumTraffic);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
