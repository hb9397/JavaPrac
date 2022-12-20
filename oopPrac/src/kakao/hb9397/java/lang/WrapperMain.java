package kakao.hb9397.java.lang;

import java.math.BigDecimal;

public class WrapperMain {
    public static void main(String[] args){
        //Wrapper 클래스 사용
        Double d = new Double(13.67);

        // 기본형을 대입하면 new Double(17.23)으로 변환 된다.
        d = 17.23;

        // toString이 재정의 되어 있으므로 출력은 참조로 가능하다.
        System.out.println(d);

        // 기본형 데이터로 변환
        double x = d;
        System.out.println(d);

        double d1 = 1.6000000000000000;
        double d2 = 0.1000000000000000;
        System.out.println(d1 + d2); // 1.70000000 ... 2가 출력

        BigDecimal b1 = new BigDecimal("1.6000000000000000");
        BigDecimal b2 = new BigDecimal("0.1000000000000000");
        System.out.println(b1.add(b2));// 1.7000...000 이 출력된다.
    }
}
