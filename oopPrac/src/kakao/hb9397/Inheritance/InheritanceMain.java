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
        // Sub s4 = new Super();

        // s3에 대입된 인스턴스는 원래 Sub 타입이기 때문에 문제가 없다.
        // 선언을 Super형으로 했기 때문에 겉으로는 Super형이지만 Sub의 내용을 참조하는 형태이기 때문에 형변환을 해도 인스턴스의
        // 내부 구조에 영향을 끼치지 않기 때문에 형 변환이 가능하다.
        Sub s4 = (Sub) s3;

        // 원래 타입이 Super 이기 때문에 예외가 발생한다.
        // 컴파일 에러가 안나는 이유는 Sub를 Sub로 형 변환하는 것 문법 자체에는 문제가 없다고 판단하기 때문에 에러가 발생하지 않는 것이고
        // 하지만 실제 실행할 때는 new Super() 로 생생된 객체는 선언도 참조도 Super형으로 하고 있기 때문에
        // Sub 클래스가 갖고 있는 내부 구조를 반영할 수 없으므로 런타임시에는 에러가 발생한다.
        Sub s5 = (Sub) (new Super());
    }
}
