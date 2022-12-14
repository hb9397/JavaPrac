package kakao.hb9397.operator;

public class Unary {
    public static void main(String[] args){
        int n1 = 20;
        int n2 = -20;

        // 정수 데이터가 2진수로 저장된 구조를 출력
        System.out.println("n1: " + Integer.toBinaryString(n1)); // 10100
        System.out.println("n2: " + Integer.toBinaryString(n2)); // 11111111111111111111111111101100

        // 1의 보수 구하기
        System.out.println("n1: " + Integer.toBinaryString(n1));
        System.out.println("~n1: " + ~n1); // -21
        System.out.println("~n2: " + Integer.toBinaryString(~n2));
        System.out.println("~n2: " + ~n2); // 19

        int n = 20;
        System.out.println(n++); // 명령에 먼저 사용하고 증감 -> 20 출력하고 n이 21이 된 상태
        System.out.println(++n); // 증감을 먼저하고 명령에 사용 -> 22
    }
}
