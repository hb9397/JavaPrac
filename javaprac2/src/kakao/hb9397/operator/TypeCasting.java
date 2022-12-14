package kakao.hb9397.operator;

import java.awt.*;

public class TypeCasting {
    public static void main(String[] args){
        double d = 37.4;
        // 실수를 정수에 직접 대입하면 실수가 정수보다 자료형이 크기 때문에 에러가 발생한다.
        //int temp = d;

        // 강제 형변환은 큰 자료형의 데이터를 작은 데이터의 자료형으로 형변환 가능
        // 그러나 실수를 정수로 강제 형변환하면 소수가 버려진다.
        System.out.println("Parsing d: " + (int)d); // 37

        short s1 = 30000;
        short s2 = 30000;
        // Java의 최소 산술연산 단위가 int이므로 s1+s2의 연산도 int로 수행되기 때문에 short result = s1 + s2;가 불가능
        // 하지만 강제 형변환을 하면 가능하다.
        // 강제 형변환을 하더라도 자료형의 범위를 넘어서는 값을 갖게 되면 OverFlow가 발생해서 최대 표현 양수를 넘어가면
        // 가장 낮은 음수부터 표현하지 못한만큼의 숫자만큼 + 되어진다.
        short sSumResult = (short)(s1 + s2);
        System.out.println(sSumResult); // -5536

        // 정수 2개의 평균을 실수로 구하고자 하는 경우
        int score1 = 91;
        int score2 = 90;

        // 정수를 가지고 산술 연산하게 되면 결과는 결국 정수이기 때문에 산술연산 후 형변환 하는 것은 의미가 없다.
        double avg = (score1 + score2) / 2;
        System.out.println("잘못된 avg: " + avg); // 90.0

        // 데이터 중 하나만 자료형을 바꿔도 해당 자료형으로 결과를 갖기 때문에 하나의 피연산자만 형변환을 해서 연산을 진행한다.
        avg = ((double) score1 + score2) / 2;
        System.out.println("올바른 avg: " + avg); // 90.5

    }
}
