package kakao.hb9397.Inheritance;

// SuperClass Class를 상속 받는 SubClass class
public class SubClass extends SuperClass{
    public void subMethod(){
        System.out.println("SubClass 만의 메서드");
    }

    // SuperClass 클래스의 메서드를 오버라이딩(상위 메서드를 다시 정의)
    @Override // 오버라이딩인지 확인할 수 있다, 오버라이딩 아닐시 에러 발생
    public  void display(){
        System.out.println("하위 클래스의 메서드");
    }
}
