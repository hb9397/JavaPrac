package kakao.hb9397.java.lang;

import java.io.UnsupportedEncodingException;

public class StringMain {
    public static void main(String[] args){
        String str = "Hello";
        System.out.println(System.identityHashCode(str));

        // String은 데이터 수정이 안되기 때문에 새로운 공간에 기존의 문자열을 복사한 후 작업을 수행하고
        // 그 참조를 다시 반환한다.
        // 기존의 데이터가 저장된 공간은 메모리 낭비가 될 수 있다.
        // str은 전형 다른 메모리 공간을 참조하게 된다.
        str += "Java";
        System.out.println(System.identityHashCode(str));

        // StringBuilder는 변경 가능한 문자열을 저장하기 때문에 문자열을 추가하면 현재 저장된 공간에 이어붙이기를 수행한다.
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(System.identityHashCode(sb));
        sb.append("Java");
        // 해쉬코드가 이전 데이터와 동일하게 찍힌다.
        System.out.println(System.identityHashCode(sb));

        // 여러 데이터를 가지고 하나의 문자열을 생성한다.
        double lat = 12.789;
        double lng = 24.2987;

        // 위의 데이터를 가지고 위도: 12.789 경도: 24.299 문자열을 생성
        String msg = String.format("위도: %.3f 경도: %.3f\n", lat, lng);
        System.out.println(msg);

        String str1 = "안녕하세요";
        // 바이트 배열로 문자열을 변환 - MS949 이용
        // 동일한 프로그램이 아니느 시스템과 채팅할 때는 문자열을 직접 전송하지 않고 바이트 배열을 만들어서 직접 전숭
        // getBytes() 메서드는 예외처리를 강제한다.
        try {
            byte [] bytes = str1.getBytes("MS949");

            // byte 배열을 문자열로 변환
            // 문자열이 깨지면 보내는 데이터와 받아오는 곳에서의 인코딩/디코딩 방식을 확인하고 변경해야 한다.
            String result = new String(bytes, "MS949");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
