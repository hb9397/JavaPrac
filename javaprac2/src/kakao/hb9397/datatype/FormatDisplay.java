package kakao.hb9397.datatype;

public class FormatDisplay {
    public static void main(String[] args){
        int n = 37;
        System.out.printf("n: %d\n", n);

        // 10자리 확보후 출력하기
        System.out.printf("n: %10d\n", n);

        // 10자리 확보후 출력하는데 실제 정수를 출력하는 10자리 중 남는 자리에 0을 추가해서 출력
        System.out.printf("n: %010d\n", n);

        double d = 23.768952;
        // 소수 6째 자리까지 출력
        System.out.printf("d: %f\n", d);

        // 소수 3째 자리까지 반올림 해서 출력
        System.out.printf("d: %.3f\n");

        String name1 = "adam";
        String name2 = "jessica";

        // %s는 문자열을 출력하는 것이 아니고 원래 %s는 시작 위치부터 byte 단위로 데이터를 가져와서 문자로 변환후 출력하는 것으로 null을 만날 때 까지 출력하는 것이다.
        System.out.printf("name1: %10s\n", name1);
        System.out.printf("name1: %10s\n", name2);

    }
}
