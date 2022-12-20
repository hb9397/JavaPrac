package kakao.hb9397.java.util;


import java.util.Arrays;

public class ArraysMain {
    public static void main(String[] args){

        // 정수 배열 만들기
        int[] IntegerArr = {50, 20, 1, 65, 0, 16};

        // 문자열 배열 만들기
        String[] StringArr = {"postId", "title", "content", "imgs"};

        System.out.println(Arrays.toString(IntegerArr));
        System.out.println(Arrays.toString(StringArr));

        // 정수 배열 정렬
        Arrays.sort(IntegerArr);
        System.out.println(Arrays.toString(IntegerArr));

        // 문자열 배열 정렬
        Arrays.sort(StringArr);
        System.out.println(Arrays.toString(StringArr));

        // VO 클래스의 인스턴스 5개를 소유하는 배열 생성
        VO [] datas = new VO[5];
        datas[0] = new VO(1, "리븐", 23);
        datas[1] = new VO(2, "워윅", 33);
        datas[2] = new VO(3, "드레이븐", 43);
        datas[3] = new VO(4, "올라프", 43);
        datas[4] = new VO(5, "다리우스", 53);

        System.out.println(Arrays.toString(datas));

        // 숫자와 문자열은 sort가 되지만 인스턴스는 ClassCastException 예외 발생
        // Arrays.sort(datas);

        Arrays.sort(datas);
        System.out.println(Arrays.toString(datas));

    }
}
