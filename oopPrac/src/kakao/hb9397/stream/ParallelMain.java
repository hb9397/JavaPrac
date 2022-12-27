package kakao.hb9397.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelMain {
    public static void main(String[] args) {
        // 정수 List 생성
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        // 일반 스트림으로 1초씩 쉬면서 출력
        // 시간 측정
        long start = System.currentTimeMillis();
        list.stream().forEach(imsi -> {
            try{
                Thread.sleep(1000);
            } catch (Exception e){}
        });
        long end = System.currentTimeMillis();
        System.out.println("일반 스트림을 통해서 List 의 요소를 Thread로 처리했을 때 걸리는 시간");
        System.out.println("걸린시간: " + (end-start));

        // 일반 스트림에 parallel을 호출(병렬)해서 으로 1초씩 쉬면서 출력
        // 시간 측정
        start = System.currentTimeMillis();
        list.stream().parallel().forEach(imsi -> {
            try{
                Thread.sleep(1000);
            } catch (Exception e){}
        });
        end = System.currentTimeMillis();
        System.out.println("\n일반 스트림에서 parallel을 호출을 통해서 List 의 요소를 병렬 Thread 처리했을 때 걸리는 시간");
        System.out.println("걸린시간: " + (end-start));
        System.out.println();
        // 코어수 확인하기
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
