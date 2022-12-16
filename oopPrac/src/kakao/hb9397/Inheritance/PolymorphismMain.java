package kakao.hb9397.Inheritance;

public class PolymorphismMain {
    public static void main(String[] args){
        // 변수를 선얼 할 때 사용한 클래스와 인스턴스를 생성하기 위해 호출한 클래스가 동일한 것은 가능하다.
        SuperClass superClass = new SuperClass();

        // superClass 변수가 호출할 수 있는 것은 SuperClass의 것들만 가능하다.
        superClass.superMethod();
        superClass.display();


        // 변수를 선언할 때 사용한 클래스와 인스턴스가 다른것이 허용되는 경우는 생성하기 위해서 호출하는 클래스가 상속관계이면 가능하다.
        // 단, 인스턴스를 생성하기 위해 호출하는 클래스가 하위 클래스여야 한다.
        SuperClass subClass = new SubClass();

        // subClass를 선언할 때는 SuperClass인데 인스턴스는 SubClass로 생성한다.
        // 이는 호출할 수 있는 것은 SuperClass를 참조하지만 호출되는 것은 SubClass의 것들임을 말한다.
        // SuperClass subClass = new SubClass(); 에서 나머지는 SuperClass를 찾아가지만 Overriding된 것은 SubClass를 찾아간다.
        subClass.superMethod(); // Overriding이 안된 메서드가 호출된다.
        subClass.display(); // Overriding된 메서드

        SuperClass obj = new SuperClass();
        // obj에 대입된 인스턴스는 SuperClass의 인스턴스
        // SuperClass의 display()가 호출된다.
        obj.display();

        obj = new SubClass();
        // 대입된 인스턴스가 SubClass 의 인스턴스
        // SubClass의 display가 호출된다.
        obj.display();
    }
}
