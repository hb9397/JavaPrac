package kakao.hb9397.nestedclass;

public class InstanceInner {
    // 내부 클래스의 특성에 static이 추가되면 외부에서 인스턴스를 만들 때 클래스이름.new 내부클래스 이름(); 으로 가능하다.
    // 안드로이드에서 View의 이벤트 처리를 위한 인터페이스들이 이런 방식으로 설계되어 있다.
    public static class Inner{
        public int score;

        // 내부 클래스에 static 멤버가 존재하면 클래스의 특성에도 static을 추가해줘야 한다.
        public static int autoIncrement;
    }
}
