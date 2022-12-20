package kakao.hb9397.java.lang;

import java.io.IOException;

public class SystemMain {
    public static void main(String [] args){
        // OS 이름 가져오기
        String os = System.getProperty(("os.name"));

        // Java version 확인하기
        String jVersion = System.getProperty(("java.version"));
        System.out.println(os);
        System.out.println(jVersion);

        long start = System.currentTimeMillis();

        for(int i=0; i<1000000000; i++){}

        long end = System.currentTimeMillis();
        System.out.println((end - start) + "밀리초");


    }
}
