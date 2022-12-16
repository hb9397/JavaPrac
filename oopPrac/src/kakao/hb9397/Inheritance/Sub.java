package kakao.hb9397.Inheritance;

public class Sub extends Super {
    // super()로 항상 상위 클래스의 기본 생성자를 호출하고 있다.
    // 만약 상위 클래스의 기본 생성자를 호출할 수 없고
    // 상위 클래스에 접근할 수 없을 때 하위 클래스에서 상위 클래스가 가지고 있는 형태의 생성자를 호출하는 방식을 사용해도 된다.
    public Sub() {
        // super()로 상위 클래스의 생성자를 호출하기 전에 다른 내용을 수행하면 에러가 발생한다.
        //
        super(1, "adam");
        // 이 안에 내용을 작성하는 것은 상관 없다.
        System.out.println("상위 클래스의 생성자를 호출한 뒤 수행");
    }

    private String nickname;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        // 상위 클래스의 toString()을 호출하고자 하는 경우
        // 하위 클래스에도 toSrting()이존재하므로.'
        // super. 도 추가해줘야 한다.

        return "Sub{" +
                "nickname='" + nickname + '\'' +
                '}';
    }

}