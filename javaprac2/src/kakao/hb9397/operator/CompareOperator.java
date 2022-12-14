package kakao.hb9397.operator;

public class CompareOperator {
    public static void main(String[] args){
        int x = -29;
        int y = -29;
        int z = -29;
        int r = -29;
        // 왼쪽으로 한 번 밀 때 마다 2를 곱하는 것과 같다.
        System.out.println("x >> 2: " + (x << 2)); // x >> 2: -116
        // 반대로 오른쪽을 밀때마다 2를 나누는 것과 같다.
        System.out.println("x << 2: " + (y >> 3)); // x << 2: -4
        // 부호 변경
        System.out.println("x >>> 3: " + (z >>> 3)); // x >>> 3: 536870908
        // 33 번 shift 연산시 32로 나눈 나머지 만큼만 수행한다.
        System.out.println("x >> 33: " + (z << 34)); // x >> 33: -116
    }
}
