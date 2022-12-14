package kakao.hb9397.datatype;

public class PrimitiveType {
    public static void main (String[] args) {
        int x = 100;
        System.out.println("x :" + x);

        // 동일한 공간에서 동일한 이름의 변수를 2번 생성하면 에러다
        // int x = 100;

        int y = 100;
        System.out.println("x:" + System.identityHashCode(x));
        System.out.println("y:" + System.identityHashCode(y));

        // 천단위 구분 _ 로 하기
        long l = 200_000_000_000L;
        System.out.println("l:" + l);

        // 16진수 저장 - 참조나 색상을 나타낼 때 많이 사용한다.
        x = 0x789;
        System.out.println("x:" + x);

        // 8진수 저장 - 권한 설정할 때 많이 사용한다.
        // rwx로 권한을 표현하는 경우가 많다.
        x = 0777;
        System.out.println("x:" + x);

        // float 형은 정밀도가 7번째 자리까지 이므로 8번째 자리 아래에서 반올림 한다.
        float f = 0.1234567890123456789f;
        System.out.println("f:" + f);

        // 문자형 저장
        char ch = 'A';
        System.out.println("ch:" + ch);
        System.out.println("ch+1:"+ ch+1);

        ch = '\337';
        System.out.println("ch"+ch);

        ch = '\uAC00';
        System.out.println("ch:"+ch);

        // integer의 경우 21억 정도까지 저장 가능한데 연산의 결과가 21억을 넘어서서 OverFlow에 해당된다.
        // 이경우 약 +21억이 넘어가면 약 -21 부터 다시 숫자를 표현하기 때문에 음수가 된다.
        x = 200000000 + 100000000;
        System.out.println("x:" + x);


        // UnderFlow - x의 음수 표현 범위를 넘어서서 가장 큰 양수의 값부터 다시 숫자를 표현함
        x = -200000000 + -100000000;
        System.out.println("x:" + x);
    }
}
