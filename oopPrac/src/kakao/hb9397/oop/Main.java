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
    }
}
