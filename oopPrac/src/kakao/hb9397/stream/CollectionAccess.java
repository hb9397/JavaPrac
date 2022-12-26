package kakao.hb9397.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CollectionAccess {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("JavaScript");
        list.add("Kotlin");

        // 반복문을 이용하는 방법
        int len = list.size();
        for(int i=0; i<len; i++){
            System.out.println(list.get(i) + "\t");
        }
        System.out.println();

        // Iterator 이용하는 방법
        // Iterator는 데이터를 가리키는 것이 아니라 다음 위치를 가리키는 포인터 역할을 가지고 있다.
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next() + "\t");
        };
        System.out.println();

        // 빠른 열거
        for(String temp: list) {
            System.out.println(temp + "\t");
        }
        System.out.println();

        // Stream API 활용
        // 내부 반복자를 이용하기 때문에 가장 빠르다

        Stream<String> stream = list.stream(); // 생성

        stream.forEach(temp -> System.out.println(temp+ "\t")); // 최종연산
    }
}
