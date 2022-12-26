package kakao.hb9397.lambda;

import java.util.ArrayList;
import java.util.List;

public class MethodNameParameter {
    public static void main(String [] args){
        // 문자열 자료형을 같는 Array List 형식의 List 생성
        List<String> list = new ArrayList<>();

        list.add("드레이븐");
        list.add("볼레베어");
        list.add("베인");
        list.add("다리우스");
        list.add("탈론");
        list.add("르블랑");

        // List의 forEach 함수는 매개변수에 적용되는 메서드들을 List 요소를 순회하면서 적용하는 메서드다.
        list.forEach((temp) -> {System.out.println(temp);});

        // 메서드 이름을 매개변수로 사용하는 방식으로 List의 forEach 사용하기
        // 람다로 구현해야 하는 메서드와 동일한 원형의 메서드 이름 대입해서 사용하는 형식
        list.forEach(System.out::println);
    }
}
