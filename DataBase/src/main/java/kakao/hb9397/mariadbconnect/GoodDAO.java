package kakao.hb9397.mariadbconnect;

import java.util.List;

// goods 테이블에 수행할 DB 작업의 원형을 소유할 인터페이스
public interface GoodDAO {
    // goods 테이블의 전체 데이터 가져오기
    // Method 선언 이름은 getAll로 지정한 것이고 전체 데이터를 가져올 것이기 때문에 String 으로 가져온다.
    // 0 줄 이상 나오는 결과는 List로 가져온다.
    public List<GoodDTO> getAll();


    // goods 테이블에서 code를 가지고 데이터를 조회하기
    public GoodDTO getGoodDTO(String code);

    // goods 테이블에 데이터 삽입하기
    // 수정은 모양이 동일하다
    // 삭제는 동일하게 만들어도 되고 매개변수를 기본키로 만들어도 된다.
    public int insertGoodDTO(GoodDTO good);

    // goods 테이블에서 name이나 manufacture에 포함된 데이터 조회
    public List<GoodDTO> likeGoodDTO(String content);
}
