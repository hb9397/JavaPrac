package kakao.hb9397.exceptionhandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.nio.Buffer;

public class ExceptionHandling_Throw {
    // throws 예외 클래스 이름 나열 ,,,  형태가 메서드 뒤에 오면 해당 메서드를 호출할 시 나열된 예외에 대한 핸들링을 해야한다.
    // 아래의 exception() 메소드를 호출 할 때 ArithmeticException 에 대해 핸들링 해야한다.
    // 실제로는 ArithmeticException이 발생할만한 코드가 있어야 한다.
    public static void exception() throws ArithmeticException{
        int kor = 10;
        int eng = 10;

        if(kor > 100 || eng > 100){
            // 강제 예외 발생
            throw new ArithmeticException("점수는 100보다 작거나 같아야 한다.");

            // Exception in thread "main" java.lang.ArithmeticException: 점수는 100보다 작거나 같아야 한다.
            //	at kakao.hb9397.exceptionhandling.ExceptionHandling_Throw.exception(ExceptionHandling_Throw.java:10)
            //	at kakao.hb9397.exceptionhandling.ExceptionHandling_Throw.main(ExceptionHandling_Throw.java:18)
            // 예외 발생
        }

        double avg = (kor + eng) / 2;
        System.out.println(avg);
    }

    public static void main(String[] args){
        exception();

        // Thread 클래스의 sleep() 메서드는 지정한 시간동안 현재 스레드의 수행을 중지하는 역할을 해주는 메서드이다.
        // 그냥
        // Thread.sleep(3000); // 다음과 같이 호출하게 되면
        // Unhandled exception: java.lang.InterruptedException 에러 발생
        // Java Document를 보면 sleep의 원형은
        // public static void sleep(long millis) throws InterrㅕptedException{} 이기 때문에
        // 아래와 같이 Interrupted Exception을 처리해야 한다.


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        String message = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));){
            message = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(message);


    }

    // 아래와 같이 main method에 예외처리를 하면 뒤에 따로 예외처리 경고 없이 코드를 수행할 수 있으나 학습 외에는 권장하지 않는다.
    /*
    public static void main(String[] args) throws Exception{
        // 에러가 발생할 가능성이 내용들
    }
    */


}
