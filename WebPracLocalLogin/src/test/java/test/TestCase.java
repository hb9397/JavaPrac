package test;

import org.junit.jupiter.api.Test;
import persistence.MemberDAO;
import service.MemberService;
import service.MemberServiceImpl;

public class TestCase {
    @Test
    public void daoTest(){
        MemberDAO dao = MemberDAO.getInstance();
        System.out.println(dao);

        System.out.println(dao.login("user", "1111")); // id pw 모두 틀린 경우
        System.out.println(dao.login("user", "1234")); // pw가 틀린경우
        System.out.println(dao.login("1234", "1111"));// id갸 틀린 경우
    }

    @Test
    public void serviceTest() {
        MemberService service = MemberServiceImpl.getInstance();
        System.out.println(service.login("user", "1111")); // DB에 있는 값
        System.out.println(service.login("user1", "1111")); // 없는값

    }
}
