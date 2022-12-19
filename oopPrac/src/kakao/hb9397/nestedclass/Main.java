package kakao.hb9397.nestedclass;

public class Main {
    public static void main(String[] args){
        /*// 외부 클래스의 인스턴스를 먼저 생성한다.
        InstanceInner instanceInner = new InstanceInner();

        // 내부 클래스의 인스턴스 생성
        InstanceInner.Inner inner = instanceInner.new Inner();/*

         */
        InstanceInner.Inner obj1 = new InstanceInner.Inner();

        // 인스턴스 생성
        // 인터페이스나 추상 클래스 등을 상속해서 클래스를 만들고 인스턴스를 만드는 경우 변수는 대부분 인터페이스나 추상 클래스 이름으로 만들고
        // 생성자는 사용하고자 하는 클래스의 생성자를 이용하는 경우가 많다.

        // 상위 클래스나 인터페이스로 만들어진 변수에 하위 클래스의 인스턴스 참조를 대입할 수 있다.
        // 이 방식으로 만들어진 변수는 상위 클래스나 인터페이스에 존재하는 이름만 호출할 수 있다.
        // 실제 호출되는 것은 생성자를 따라 간다.
        // 컴파일 시에는 상위 클래스나 인터페이스를 확인하고 실행될 때는 하위 클래스를 참조해서 실행한다.
        SampleAble instance = new SampleAbleImpl();

        // 메서드 호출
        instance.method();

        // Anonymous Class 사용
        // 인터페이스 자체로 생성자를 사용할 수는 없다.
        SampleAble anonymous = new SampleAble() {
            // 추상 메서드를 가지고 있다면 자동으로 생성해 준다.
            @Override
            public void method() {
                System.out.println("anonymous 이용");
            }
            // 앞서 SampleAbleImpl 클래스를 만들고 추상메서드를 구현한 뒤 Main에서 SampleAble instance = new SampleAbleImpl();를
            // 생성한것과 동일하다.
            // 딱 한 번만 사용되는 클래스를 만드는 경우 이렇게 작성하는 것이 더 효율적일 수 있다.
        };
        anonymous.method(); // 오버로딩한 메서드 호출

        // 메서드를 단 한 번만 호출할 거라면 변수를 생성하지 않고도 가능하다.
        new SampleAble(){
            @Override
            public void method(){
                System.out.println("변수를 만들지 않고 Anonymous 사용");
            }
        }.method();

        GlobalData.global = 10;


        // 디자인 패턴이 적용되지 않은 경우의 인스턴스 생성
        // Singleton singleton1 = new Singleton();
        // Singleton singleton2 = new Singleton();

        // Singleton 디자인 패턴을 적용한 경우의 인스턴스 생성
        Singleton singleton1 = Singleton.sharedInstance();
        Singleton singleton2 = Singleton.sharedInstance();

        // 참조 해쉬코드 확인
        // 같은 해쉬코드를 참조한다.
        System.out.println(System.identityHashCode(singleton1));
        System.out.println(System.identityHashCode(singleton2));

        Table row1 = new Table();
        System.out.println(row1.getNum()); // 1

        Table row2 = new Table();
        System.out.println(row2.getNum());// 2

        Table.setStep(10);
        Table row3 = new Table();
        System.out.println(row3.getNum()); // 12
    }
}
