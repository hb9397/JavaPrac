package kakao.hb9397.Inheritance;

public class InheritanceMain {
    public static void main(String[] args){
        Sub sub = new Sub();

        // Sub가  Super를 상속받기 때문에 Sub에 만들지 않았던 setNum과 setName을 사용할 수 있다.
        // getter 메서드도 마찬가지
        sub.setNum(1);
        sub.setName("adam");
        sub.setNickname("군계");

        System.out.println(sub); // num과 name은 상위 클래스에서

        Super s1 = new Super();
        Sub s2 = new Sub();

        // 상위 클래스 타입의 참조형 변수에는 하위 클래스 타입의 인스턴스 참조를 바로 대입할 수 있다.
        Super s3 = new Sub();

        // 하위 클래스 타입의 참조형 변수에는 상위 클래스 타입의 인스턴스 참조를 대입할 수없다.
        // 강제 형변환을 하면 가능하긴 하다.
        // Sub s4 = new Spuer();

        // s3에 대입된 인스턴스는 원래 Sub 타입이기 때문에 문제가 없다.
        Sub s4 = (Sub) s3;

        // 원래 타입이 Super 이기 때문에 예외가 발생한다.
        // Sub가 원래 Super를 상속받은 타입이기 때문에 원래 타입이 Super라서 불가능하다.
        // 컴파일 에러가 안나는 이유는
        Sub s5 = (Sub) (new Super());
    }
}
