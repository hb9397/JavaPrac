package kakao.hb9397.mariadbconnect;

public class GoodMain {
    public static void main(String[] args) {
        GoodDAO dao = GoodDAOImpl.getInstance();
        // 전체 데이터 가져오기
        System.out.println(dao.getAll());

        // 데이터 전체 가져오기
        System.out.println(dao.getAll());

        // 기본키 가지고 조회하면 존재하는 경우는 데이터가 반환도히고 없는경우  null이 반환된다.
        System.out.println(dao.getGoodDTO("1"));
        System.out.println(dao.getGoodDTO("20"));
    }
}
