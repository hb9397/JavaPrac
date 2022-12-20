package kakao.hb9397.java.lang;

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
    }
}
