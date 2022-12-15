package kakao.hb9397.oop;

public class Student {
    // 인스턴스 속성 생성
    // 접근 지정자가 public 이므로 외부에서 인스턴스를 통해서 접근해 사용할 수 있다.

    // protected는 자신의 클래스 에서나 상속받은 클래스에서만 사용가능하다고 하지만
    // 실제로는 같은 패키지에 있는 클래스에서는 public으로 취급 된다.
    protected int num;
    public String name;
    public int kor;
    public int eng;
    public int mat;
}
