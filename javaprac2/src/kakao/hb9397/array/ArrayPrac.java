package kakao.hb9397.array;

import java.util.Arrays;

public class ArrayPrac {
    public static void main(String[] args){
        // 데이터를 가지고 배열 생성
        String [] soccers = {"반바스텐", "굴리트", "리카르도", "차범근"};

        // 배열의 데이터 순회
        int len = soccers.length;
        for(int i=0; i<len; i=i+1){
            String imsi = soccers[i];
            System.out.println(imsi);
        }

        // 크기만 지정하고 생성한 뒤 데이터를 대입
        int [] ar = new int[3];
        ar[0] = 20;
        ar[1] = 30;

        // 배열의 순회
        for(int temp: ar){
            System.out.printf("%5d", temp);
        }

        // try catch문에 입력하면 nullpointerexception 을 catch할 수 있다.
        try {
            // null값으로 설정된 개체 참조를 사용할 때 발생하는 NullPointerException 예외
            int [] br = null; // null도 참조형 객체이기 때문에 br에 = 할당 연산자로 가능하다고 판단해 오류는 생기지 않는다.
            System.out.println(br[0]); // 하지만 index로 배열의 요소에 접근한 상태로 컴파일 되면 런타임 예외가 발생한다.
        }catch (Exception e){System.out.println();}

        String [][] programmers = {{"데니스 리치히", "바야네 스트롭스트롭", "아네르스 하일스베르"},
                {"귀도 반 로섬", "제임스 고슬링", "켄 톰슨"}};

        System.out.println(programmers.length); // 행의 개수 - 2
        System.out.println(programmers[0].length); // 열의 개수 - 3

        // 2차원 배열 순회 접근시 아래와 같이 for문을 두번 사용하게 된다.
        for(String [] ar1: programmers){
            for(String designer: ar1){
                System.out.print(designer);
            }
            System.out.println();
        }

        String [] ar3 = {"레지밀러", "찰스바클리", "스캇피펜"};
        // 위의 배열의 내용을 가지고 데이터를 1개 추가한 배열을 생성한다.
        String [] br3 = new String[ar.length + 1];
        // 배열의 요소 복제 직접 구현
        for(int i=0; i<ar.length; i++){
            br3[i] = ar3[i];
        }
        br3[3] = "후엥";

        // Arrays.copy() 메서드로 배열 복제
        String [] cr3 = Arrays.copyOf(ar3, ar3.length + 1);
        cr3[3] = "하킴 올라주원";

        // 배열을 요소들을 하나의 문자열로 생성
        System.out.println(Arrays.toString((cr3)));

        // 배열을 Arrays.sort() 메서드로 정렬 기본값은 오름차순
        Arrays.sort(cr3);
        System.out.println(Arrays.toString(cr3));

        // 선택정렬
        // 첫번째 부터 마지막 자리까지
        int [] ar4 = {1, 5, 3, 2, 4};
        for (int i=0; i < ar4.length-1; i++){
            // 기준의 뒤부터 마지막 자리까지
            for(int j=i+1; j < ar4.length; j++){
                // 각 자리의 데이터를 비교해서 기준 자리의 데이터가 크면 2개의 데이터를 Swap한다.
                if(ar4[i] > ar4[j]){
                    int temp = ar4[i];
                    ar4[i] = ar4[j];
                    ar4[j] = temp;
                }
            }
            System.out.print(i+1+" PASS: ");
            System.out.println(Arrays.toString(ar4));
        }
    }
}
