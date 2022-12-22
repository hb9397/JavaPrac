package kakao.hb9397.java.util;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args){
        // 1 ~ 45 사이의 랜덤한 정수를 가져ㅇ기
        Random r = new Random();

        int lotto = r.nextInt(45)+1;
        System.out.println(lotto);

        // 복원 추출은 추출의 결과에 중복을 허용하는 것이고 비복원 추출은 추출의 결과에 중복을 허용하지 않는 것이다.
        // 배열에서 랜덤한 아이템 추출하기
        String[] card = {"스페이드", "다이아몬드", "하트", "클로버"};
        String myCard = card[r.nextInt(card.length)];
        System.out.println(myCard);
    }
}
