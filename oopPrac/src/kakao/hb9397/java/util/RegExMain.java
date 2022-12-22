package kakao.hb9397.java.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMain {
    public static void main(String[] args){
        // 정규 표현식 객체 사용
        // 문자열 배열에서 a로 시작하고 c로 끝나는 3글자 조회하기
        String [] ar = {"abc", "asc", "aiic"};

        // 정규식 생성
        // a로 시작하고 아무글자나 하나 있고 c로 끝나는
        Pattern p = Pattern.compile("^a.c$");

        for(String str : ar) {
            // 정규식 패턴과 일치하는지 조사하기
            Matcher matcher = p.matcher(str);
            System.out.println(str + ":" + matcher.find());
        }
    }
}
