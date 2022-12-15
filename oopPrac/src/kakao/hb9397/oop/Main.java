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

        // 매개변수에 따른 Static method 호출
        MethodClass.noArgsMethod();
        MethodClass.oneArgsMethod(3);
        MethodClass.twoArgsMethod(3, "twoArgsMethod");

        // 반환이 없는 인스턴스 메서드 사용
        MethodClass obj = new MethodClass();
        obj.addWithInteger(10, 30);

        // 반환이 있는 인스턴스 메서드 사용
        MethodClass obj1 = new MethodClass();

        // return 된 결과 가져오기
        int result = obj1.addWithInteger1(11, 31);
        // return된 결과 재사용하기
        result = obj1.addWithInteger1(10, result);
        System.out.println("결과: " + result);


            int x = 10;
            MethodClass.callByValue(x);
            // 기본형을 메서드에게 넘겨준 경우에 데이터가 변경되지 않는다.
            System.out.println(x); // x값은

            int [] br = {10, 20, 30};
            MethodClass.callByReference(br);
            // 배열을 메서드에게 넘기면 배열의 내용이 변경될 수 있다
            // 매서드의 반환이 없는 경우라면 print 메서드를 제외하고는 원본을 변경 해주는 것이다.
            System.out.println("br[0]:" + br);


        MethodClass o1 = new MethodClass();
        o1.thisMethod();

        // 20번째 피보나치 수열의 값 (재귀 X)
        int n = 5;
        int f_1 = MethodClass.noRecursionFibonacci(n);
        System.out.println("noRecursionFibonacci" + n + "th: " + f_1);

        // 20번째 피보나치 수열의 값(재귀 O)
        int f_2 = MethodClass.noRecursionFibonacci(n);
        System.out.println("recursionFibonacci" +  n + "th: " + f_2);

        // display 메서드의 매개 변수가 String ...args로 가변적이여서 자료형만 맞다면 문자열을 얼마나 주든 상관이 없다.
        MethodClass.display("굴리트");
        MethodClass.display("베켄바우어", "마테우스");
        MethodClass.display("해글러", "헌즈", "레너드", "두란");
    }


}
