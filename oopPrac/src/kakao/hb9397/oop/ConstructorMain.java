package kakao.hb9397.oop;

import java.util.Date;

public class ConstructorMain {
    public static void main (String[] args) {
        // 인스턴스 생성
        Member member = new Member();

        member.setEmail("abcd@efgh.com");
        member.setPassword("1234");
        member.setMarried(true);
        member.setAge(25);

        // 오늘 날짜
        // member.setBirthday(new Date());
        // month는 1 빼야 하고 년도는 두자리
        // 현재는 Date 클래스 보다는 LocalDate, LocalDateTime을 많이 사용한다.
        member.setBirthday(new Date(198, 0, 1)); // 2000년대는 + 100 해서 사용한다.

        // 배열 삽입
        String[] nicknames = {"adam", "군계"};
        member.setNicknames(nicknames);

        System.out.println(member);

        // 메서드를 이용한 초기화 - 초기화 메서드 생성
        // 속성 초기화 하는 메서드를 호출하면 위의 코드처럼 setter 함수를 6개 호출할 필요가 없다.
        // Line 수가 중요한것이 아니라 메서드 호출 횟수(1MB)가 줄기 때문에 메모리 스택을 아낄 수 있다. 약 7MB -> 2MB

        Member member1 = new Member();
        member1.init("qwer@zxcv.com", "1234", nicknames, new Date(), false, 54);
        System.out.println(member1);

        // 생성자를 이용한 초기화
        // 메서드를 한번만 호출해서 위의 init 함수나 setter 6개의 역할을 대신할 수 있다.
        Member member2 = new Member("qwer@zxcv.com", "1234", nicknames,
                new Date(), false, 54);
    }
}
