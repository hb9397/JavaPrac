package kakao.hb9397.java.lang;

// 이런 형태로 만들면 Gender Type의 변수에 MAN 아니면 WOMAN 만가능
enum Gender {
    MAN, WOMAN;
}

    public class EnumMain {
    public static void main(String[] args){

        final int MAN = 0;
        final int WOMAN = 1;

        // int로 만들면 이렇게 정의하지 않은 값을 대입하는게 가능하다
        int gender = MAN;
        gender = 3;

        // Gender가 enum 이므로 Gender.MAN 이나 Gender.WOMAN만 가능하다.
        Gender t = Gender.MAN;
    }
}
