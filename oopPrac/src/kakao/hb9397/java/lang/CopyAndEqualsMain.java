package kakao.hb9397.java.lang;

public class CopyAndEqualsMain {
    public static void main(String[] args){
        String [] nicknames = {"adma", "군계", "파이터"};

        // 인스턴스 생성
        Data original = new Data(1, "hb9397", nicknames);

        // 인스턴스의 참조 복사
        // 참조 대상이나 원본이 내부 데이터를 변경하면 영향을 준다.
        Data data = original;
        System.out.println(original);

        // 참조를 복사한 경우는 복사본의 변경이 곧 original 의 변경을 의미한다.
        data.setNum(3);
        System.out.println(original);


        // 자바는 복제를 이용하고자 하는 경우 clone 메서드를 재정의 해야한다.
        // 재정의 할 때 Cloneable 인터페이스를 implements 하기를 권장한다.
        Data copy = original.clone();
       System.out.println(original);
       // 숫자 기본 자료형과 String 은 값을 바로 갖고 있어서 얕은 복사로 복제된 값이 copy에 생겨서 original에 영향을 주지 않는다.
        // 하지만 값이 아닌 참조형을 바로 대입한 Arrays는 참조를 그대로 복제된 상태로 copy의 두개의 자료형 속성은 변경되면 original에 영향을준다.
       copy.setNum(7);
       copy.setName("블리츠");
       String [] names = copy.getNicknames();
       names[0] = "아담";
       System.out.println(original); // original은 변경되지 않는다.

        Data data1 = new Data(1, "구름", null);
        Data data2 = new Data(1, "구름", null);
        // ==  는 참조를 비교하는 연산자
        // 2개의 인스턴스는 각각의 생성자를 호출해서 만들었기 때문에 참조가 다르며 당연히 == 연산은 false를 반환
        // 인스턴스의 내용이 같은지 확인 할 때는 equals 메서드를 재정의 해서 사용한다.
        System.out.println(data1 == data2);

        // 재정의 하지 않고 사용하면 false 출력
        System.out.println(data1.equals(data2));
    }
}
