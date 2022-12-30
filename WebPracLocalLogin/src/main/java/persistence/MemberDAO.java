package persistence;

import domain.MemberVO;
import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class MemberDAO {
    // 싱글톤 패턴을 위한 코드 - Spring에서는 필요 없다.

    private MemberDAO(){

    }

    private static MemberDAO dao;

    public static MemberDAO getInstance(){
        if(dao == null){
            dao = new MemberDAO();
        }
        return dao;
    }

    // 데이터 베이스 접속 코드
    static {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 로드 성공");
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    // 데이터 베이스 사용을 위한 속성
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    // 데이터 베이스 연결
    { // {} -> init 블럭
        // 생성자를 호출할 때마다 먼저 호출되며 해당 영역은 inti 라는 메서드로 생성할 수 있고 모든 속성을 사용할 수 있다.
        try{
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/JavaPrac",
                    "root",
                    "8236"
            );
            System.out.println("DB 접속 성공");
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    // 로그인 처리를 위한 메서드
    // 아이디와 비밀번호를 받아와서 처리한 후 회원정보를 반환하는 형태를 주로 사용한다.
    public MemberVO login(String mid, String mpw){
        MemberVO vo = null;

        try {
            // 수행할 SQL 생성
            String sql = "select * from tbl_member where mid=? and mpw=?";

            // sql 매개변수 조작
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mid);
            pstmt.setString(2, mpw);

            // SQL 실행
            resultSet = pstmt.executeQuery();

            // sqld 이 요청된다면
            if(resultSet.next()){
                vo = new MemberVO();
                vo.setMid(resultSet.getString("mid"));
                vo.setMname(resultSet.getString("mname"));
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        return vo;
    }
}
