package kakao.hb9397.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReductionOperator {
    public static void main(String[] args){
        List<String> list = Arrays.asList("홍범도", "유관순", "안중근", "안창호", "이순신", "남자현", "윤봉길", "홍범도");

        // Stream 인스턴스를 Arrays.list 로 생성
        // Stream 인스턴스는 한번 사용하면 해제된다.
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = list.stream();
        Stream<String> stream3 = list.stream();
        Stream<String> stream4 = list.stream();
        Stream<String> stream5 = list.stream();
        Stream<String> stream6 = list.stream();

        // 전체 출력
        System.out.println("Stream 인스턴스 전체 출력");
        stream1.forEach((temp) -> System.out.println(temp + "\t"));
        System.out.println("");
        System.out.println("");


        // 2개 빼고 출력
        System.out.println("Stream 중간연산으로 2개 빼고 Stream 인스턴스의 전체요소 출력");
        stream2.skip(2).forEach((temp) -> {
            System.out.println(temp + "" + "\t");
        });
        System.out.println("");
        System.out.println("");

        // 2개 건너뒤고 3개 사용
        System.out.println("Stream 중간연산으로 2개 건너뛰고 Stream 인스턴스 3개만 출력");
        stream3.skip(2).limit(3).forEach((temp) -> {
            System.out.println(temp + "" + "\t");
        });
        System.out.println("");
        System.out.println("");

        // 중복 제거하고 출력
        System.out.println("Stream 중간연산으로 중복되는 요소를 제거하고 Stream 인스턴스의 전체요소 출력");
        stream4.distinct().forEach((temp) -> {
            System.out.println(temp + "" + "\t");
        });
        System.out.println("");
        System.out.println("");

        // fileter - 매개변수가 1개이고  Boolean 을 반환하는 함수를 대입
        System.out.println("Stream 중간연산으로 안 으로 시작하는 요소만 필터링해서 Stream 인스턴스의 전체요소 출력");
        stream5.filter((name) -> name.charAt(0) == '안').forEach((temp) -> System.out.println(temp));
        System.out.println("");
        System.out.println("");

        // ㅇ(이응)으로 시작하는 요소만 필터링해서 Stream 인스턴스의 전체요소 출력
        System.out.println("Stream 중간연산으로 이응(ㅇ)으로 시작하는 요소만 필터링해서 Stream 인스턴스의 전체요소 출력");
        stream6.filter((name) -> name.charAt(0) >= '아' && name.charAt(0) < '자').forEach((temp) -> System.out.println(temp));
        System.out.println("");
        System.out.println("");

        // Map - 매개변수가 1개이고 반환이 있는 메서드를 이용해서 데이터의 자료형이나 값을 변경하는 중간 연산
    }
}
