package kakao.hb9397.exceptionhandling;

import java.util.Arrays;

public class DebuggingMain {

    // 디버깅을 위한 test 메서드
    public static void test(){
        int x = 10;
        int [] ar = {30, 40 ,50, 60};
        x = 30;

        System.out.println(x);
        ar[2] = 90;
        System.out.println(Arrays.toString(ar));
    }

    public static void main(String[] args){

    }
}
