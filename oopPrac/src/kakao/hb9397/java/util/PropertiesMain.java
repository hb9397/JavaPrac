package kakao.hb9397.java.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesMain {
    public static void main(String[] args){
        // 인스턴스를 1개만 만들 때 참조하는 이름은 클래스 이름을 그대로 작성하고 첫 글자만 소문자로 변경한다.
        // Spring이 Bean 을 만들 때 사용하는 방법이다.
        Properties properties = new Properties();

        // 데이터 저장
        properties.setProperty("num", "1"); // 값에 문자열 만 줄 수 있다.
        properties.setProperty("name", "adam");

        // 데이터 읽어오기
        System.out.println(properties.getProperty("num"));
        System.out.println(properties.getProperty("name"));

        // 존재하지 않는 Key를 사용하는 경우 null
        System.out.println(properties.getProperty("number"));

        // Enumeration - 반복자 사용
        Enumeration<Object> keys = properties.keys();

        while(keys.hasMoreElements()){ // keys Object에 요소가 있다면
            System.out.println(keys.nextElement()); // 요소들을 반환한다.
        }

        // 파일로 저장하기
        try {
            // 현재 프로젝트 폴더에 아래의 두개 Properties 파일이 저장되어 있는 것을 확인한다
            properties.store(new FileOutputStream("./pro.properties"), "텍스트로 저장");
            properties.storeToXML(new FileOutputStream("./pro.xml"), "XML로 저장");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
