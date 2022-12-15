package kakao.hb9397.oop;

public class Main {
    public static void main(String[] args){
        // Student 클래스의 인스턴스 생성
        Student student = new Student();

        // 생성한 인스턴스 속성에 접근

        // Main 클래스에서 Student 클래스의 protected 속성을 같은 패키지에 있기때문에 그냥 사용하는 것이 가능하다.
        student.num = 1;
        student.name = "아이린";
        student.kor = 32;
        student.eng = 19;
        student.mat = 40;

        // 또 다른 Student 인스턴스 생성
        Student student1 = new Student();
        student1.num = 2;

        // 인스턴스 속성은 인스턴스 별로 갖는다
        System.out.println("student.num: " + student.num);
        System.out.println("student1.num: " + student1.num);

        //자바는 static 속성에 인스턴스가 접근할 수 있다.
        student.schoolName = "명덕고등학교";
        student1.schoolName = "제일고등학교";

        // static 속성은 모든 인스턴스가 공유하기 때문에 동일한 데이터가 출력된다.
        System.out.println("student.schoolName: " + student.schoolName); // 제일고등학교
        System.out.println("student1.schoolName: " + student1.schoolName); // 제일고등학교

        // static method는 클래스 이름으로 호출 가능
        MethodClass.method1();

        // instance method는 클래스 이름으로 호출 불가
        // MethodClass.method2();
        // instance method 호출
        MethodClass methodClass = new MethodClass();
        methodClass.method2();

        // Java는 instance를 이용해서 static method 호출 가능
        methodClass.method1();

        // 참조형 변수를 만들지 않고 인스턴스를 만들어서 메서드 호출
        // 인스턴스를 딱 한번만 사용할 때 이름을 만들지 않는 것이 좋다.
        // 무조건 예측해서 사용하기 보다는 변수에 선언해서 사용하다가 한 번 밖에 쓰지 않은 instance를 찾아서 코드를 변환하는 것이 좋다.
        new MethodClass().method2();
    }
}
