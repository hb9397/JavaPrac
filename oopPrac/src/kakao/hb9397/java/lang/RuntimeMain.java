package kakao.hb9397.java.lang;

import java.io.IOException;

public class RuntimeMain {
    public static void main(String[] args){
        // Runtime 클래스의 인스턴스 생성
        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();
        // Runtime 클래스는 싱글톤으로 디자인 되어서 인스턴스들의 해시코드가 동일하다
        System.out.println(System.identityHashCode(r1));
        System.out.println(System.identityHashCode(r2));

        // 프로세스 실행
        // Mac 에서는 open 파일경로 형태로 입력해야 되며 exec는 예외 처리를 강제한다.
        try {
            // notepad 만 입력하면 빈 메모장을 실행시키는 것이고 메모장으로 열수 있는 파일의 경로명도 같이 입력하면 해당 파일 실행
            r1.exec("notepad C:\\VsCode\\NodePrac\\MongoDB.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
