package kakao.hb9397.java.lang;

public class EnumerationMain {
    public static void main(String[] args){
        // 기본값이 0을 가지고 1000000 개의 데이터를 가진 배열 생성
        int [] ar = new int[1000000];

        long start1 = System.currentTimeMillis();
        for(int i=0; i<ar.length; i++){
            System.out.println(ar[i]);
        }
        long end1 = System.currentTimeMillis();

        System.out.println("인덱스를 이용한 순회 수행 시간" + (end1 - start1) + "밀리 초");

        long start2 = System.currentTimeMillis();
        // 빠른 열거 FastEnumration 사용
        for(int temp: ar){
            System.out.println(temp);
        }
        long end2 = System.currentTimeMillis();

        System.out.println("빠른 열거를 이용한 순회  수행 시간" + (end2 - start2));

    }
}
