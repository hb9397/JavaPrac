package kakao.hb9397.nestedclass;

public interface SampleAble {
    // 인터페이스 안에 속성을 만들면 final 변수가 된다.
    // 인터페이스 안에 메서드를 만들면 abstract method가 되며 메서드를 만들 때 내용을 추가하려면 default라는 키워드를 추가해야한다.
    // 인터페이스는 인스턴스를 생성할 수 없다. - 변수생성은 가능하다(추상 클래스도 마찬가지)
    // 클래스에 implements 해서 사용한다.

    // 자동으로 추상 메서드가 되며 추상 메서드는 반드시 하위 클래스에서 재정의 해야 한다.
    public void method();
}
