package kakao.hb9397.mariadbconnect;

public class GoodMain {
    public static void main(String[] args) {
        GoodDAO dao = GoodDAOImpl.getInstance();
        // 전체 데이터 가져오기
        // System.out.println(dao.getAll());

        // 기본키 가지고 조회하면 존재하는 경우는 데이터가 반환도히고 없는경우  null이 반환된다.
        /*System.out.println(dao.getGoodDTO("1"));
        System.out.println(dao.getGoodDTO("20"));*/


        // 한번 삽입하면 기본키는 유일해야 하기 때문에 같은 기본키로는 삽입 불가하다.
        /*GoodDTO goodDTO = new GoodDTO();
        goodDTO.setCode("11");
        goodDTO.setName("과자");
        goodDTO.setManufacture("서울");
        goodDTO.setPrice(8000);

        int r = dao.insertGoodDTO(goodDTO);
        if(r == 1){
            System.out.println("삽입 성공");
        } else{
            System.out.println("삽입 실패");
        }*/

        System.out.println(dao.likeGoodDTO("한"));

    }
}
