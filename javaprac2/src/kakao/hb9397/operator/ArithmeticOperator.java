package kakao.hb9397.operator;

public class ArithmeticOperator {
    public static void main(String[] args){
        short s1 = 20;
        short s2 = 30;

        // short 사이의 덧셈이고 결과도 50이라서 short형 저장이 가능하지만 아래의 문장은 Error
        // Java의 산술연산의 최소 단위는 int 이기 때문이다.
        // 결과는 int가 되기 때문에 short에 저장불가
        // 이러한 경우 결과를 int에 저장하던가 강제 형 변환을 통해서 short에 저장해야 된다.
        // short sResult = s1 + s2;
        int sResult = s1 + s2;

        // 실수의 산술 연산의 결과
        double d = 0.1;
        double tot = 0.0;
        int i;
        for(i = 0; i<100; i++){
            tot = tot+d;
        }
        System.out.println("반복문이 끝난 다음의 i의 값 : " + i); // 100
        // 0.1을 100번 더했는데 10이 아닌 9.99999999999998를 갖는다.
        System.out.println("tot: " + tot);

        // 나누기 연산에서 0으로 나누는 것이 에러가 아닐 수 있다.
        // 연산이 안되는 경우 Infinity나 NaN이 될 수 있다.
        System.out.println(5/0.0);


    }
}
