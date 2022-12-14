package kakao.hb9397.operator;

public class RelationOperator {
    public static void main(String[] args){
        System.out.println(10 > 3);
        // 정수끼리는 자료형이 달라도 크기 비교가 가능하다
        System.out.println(10 > 10L);
        System.out.println(10L > 10);
        // 실수는 크기 비교에서도 정확한 결과를 만들어내지 못할 수 있다.
        System.out.println((1.0-0.8) >= 0.2);

        int n1 = 10;
        int n2 = 10;
        long n3 = 10L;
        System.out.println(n1 == n2);
        System.out.println(n1 == n3);
        // 실수나 문자열은 주의
        // 문자열의 경우는 리터럴으로 만들었냐 외부에서 입력받았냐에 따라 다른 결과가 만들어질 수 있다.
        // Literal 을 이용해서 생성된 s1, s2는 데이터가 같으므로 동일한 해시코드를 갖는다.
        String s1 = "JAVA";
        String s2 = "JAVA";
        System.out.println(s1 == s2); // true
        System.out.println("s1: " + System.identityHashCode(s1)); // s1: 1435804085
        System.out.println("s2: " + System.identityHashCode(s2)); // s2: 1435804085

        java.util.Scanner sc = new java.util.Scanner(System.in);
        // s3은 ""안에 선언된 것이 아니기 때문에 리터럴 취급되지 않아 static영역에 올라가지 않는다.
        // 동일한 JAVA를 입력해도 다른 hash code를 갖는다.
        System.out.print("문자열을 입력하세요(JAVA) : ");
        String s3 = sc.nextLine();
        System.out.println("s3: " + s3);
        // 해쉬코드가 달라서 false가 출력된다.
        System.out.println(s1 == s3); // false
        System.out.println("s3: " + System.identityHashCode(s3)); // s3: 2081853534
        // 인스턴스의 경우는 equals로 내용을 비교한다.
        // 무작정 String이라고 인스턴스.equals(인스턴스)로 비교하는 것이 아니다.
        System.out.println("인스턴스는 equls로 비교 s1.equals(s3): " + s1.equals(s3));
    }
}
