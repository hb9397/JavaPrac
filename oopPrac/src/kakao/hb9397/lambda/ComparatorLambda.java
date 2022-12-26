package kakao.hb9397.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args){
        // 데이터 정렬을 위해 문자열 배열 생성
        String [] ar1 = {"드레이븐", "탈리야", "야스오", "요네","리븐", "다리우스", "사이온"};

        // 일반적인 Comparator 인터페이스를 활용한 내림차순 형태의 sort 구현하기
        Arrays.sort(ar1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(ar1));

        // Lambda 와 Comparator 인터페이스를 이용한 오름차순 형태의 sort 구현
        // 코드는 매우 간결해지지만 자료형이나 반환값등의 명시적인 측면에서 가독성은 떨어졌다.
        Arrays.sort(ar1, (o1, o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(Arrays.toString(ar1));
    }
}
