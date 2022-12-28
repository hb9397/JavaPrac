/*
package kakao.hb9397.mariadbconnect;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GoodDAOImpl implements GoodDAO {
    // 싱글톤을 만들기 위한 코드 - 안 중요
    // 외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설계
    private GoodDAOImpl() {}
    // 참조를 저장할 변수를 static 으로 생성
    private static GoodDAO goodDAO;
    // 변수가 null 이면 생성하고 리턴하고 null이 아니면 바로 리턴
    public static GoodDAO getInstance() {
        if (goodDAO == null) {
            goodDAO = new GoodDAOImpl();
        }
        return goodDAO;
    }

    private Connection connection; // DB 연결
    private PreparedStatement pstmt; // sql 실행
    private ResultSet resultSet; // select 구문의 결과

    private static void getDBConnection(){

    };

    // static 초기화 - static 속성만 사용할 수 있다.
    static{
        // 데이터베이스 접속에 필요한 정보 불러오기
        String driver = null;
        String url = null;
        String id = null;
        String password = null;

        // 읽어올 파일 인스턴스 생성
        File file = new File("./db.properties");

        try(FileInputStream fileInputStream = new FileInputStream(file)){

            // 파일의 내용을 properties에 저장
            Properties properties = new Properties();
            properties.load(fileInputStream);

            // 읽어온 내용을 변수에 저장
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            id = properties.getProperty("id");
            password = properties.getProperty("password");

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        // 1. 데이터베이스 드라이버 로드
        // 드라이버 의존성을 설정하지 않거나 클래스 이름이 틀리면
        // 예외 발생
        try {
            Class.forName(driver);
            System.out.println("드라이버 로드 성공");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    // 일반 초기화 - 생성자를 호출할 때 항상 먼저 호출되며 이 영역은 init라는 메서드로 생성하고 모든 속성을 이용할 수 있다.
    {
        // 데이터베이스 접속에 필요한 정보 불러오기
        String driver = null;
        String url = null;
        String id = null;
        String password = null;

        // 읽어올 파일 인스턴스 생성
        File file = new File("./db.properties");

        try(FileInputStream fileInputStream = new FileInputStream(file)){

            // 파일의 내용을 properties에 저장
            Properties properties = new Properties();
            properties.load(fileInputStream);

            // 읽어온 내용을 변수에 저장
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            id = properties.getProperty("id");
            password = properties.getProperty("password");

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        // 2. 데이터베이스 접속 - java.sql.Connection
        try (Connection connection = DriverManager.getConnection(url, id, password)){
            System.out.println(connection);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    // GoodDAO Interface 의 메서드를 재정의해야 한다.(모든 데이터를 가져오는 메서드)
    @Override
    public List<GoodDTO> getAll(){
        // List는 조회할 데이터가 없더라도 인스턴스를 생성한다.
        // 조회할 데이터가 없다는 사실은 size() 가 0 을 갖게 된다.
        List<GoodDTO> list = new ArrayList<>();

        try {
            // SQL 실행 클래스의 인스턴스를 생성한다.
            pstmt = connection.prepareStatement("select * from goods");

            // SQL 실행
            resultSet = pstmt.executeQuery();

            // 데이터를 하나의 행씩 읽어서 DTO 객체로 변환해서 list 에 대입
            while(resultSet.next()){
                GoodDTO goodDTO = new GoodDTO();
                goodDTO.setCode(resultSet.getString("code"));
                goodDTO.setName(resultSet.getString("name"));
                goodDTO.setManufacture(resultSet.getString("manufacture"));
                goodDTO.setPrice(resultSet.getInt("price"));
            }

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return list;
    };

    // goods 테이블에서 code를 가지고 데이터 조회하기
    public GoodDTO getGoodDTO(String code){
        // 조회가 안된 경우는 null
        GoodDTO goodDTO = null;
        try{
            pstmt = connection.prepareStatement(
                    "select * from goods where code = ?"
            ); // ? 에 바인 -> 바인딩 인덱스는 1부터 시작한다.

            pstmt.setString("");

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return goodDTO;
    };
}
*/
package kakao.hb9397.mariadbconnect;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodDAOImpl implements GoodDAO {
    // 싱글톤을 만들기 위한 코드 - 안 중요
    // 외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설계
    private GoodDAOImpl() {}
    // 참조를 저장할 변수를 static 으로 생성
    private static GoodDAO goodDAO;
    // 변수가 null 이면 생성하고 리턴하고 null이 아니면 바로 리턴
    public static GoodDAO getInstance() {
        if (goodDAO == null) {
            goodDAO = new GoodDAOImpl();
        }
        return goodDAO;
    }

    private Connection connection; // 데이터베이스 연결
    private PreparedStatement pstmt ; // sql 실행
    private ResultSet rs; // select 구문의 결과

    // static 초기화 - 클래스가 로드 될 때 1번만 수행
    // static 속성만 사용 가능
    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
//            System.out.println("드라이버 로드 성공");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }


    }
    // 초기화 - 생성자를 호출할 때 마다 먼저 호출됨.
    // 이 영역은 init 이라는 메서드로 생성
    // 모든 속성 사용이 가능
    {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/JavaPrac", "root", "8236");
            System.out.println(connection);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<GoodDTO> getAll() {
        // List는 조회할 데이터가 없더라도 인스턴스를 생성
        // 조회할 데이터가 없다는 사실은 size() 가 0임.
        List<GoodDTO> list = new ArrayList<GoodDTO>();

        try {
            // SQL 실행 클래스의 인스턴스를 생성
            pstmt = connection.prepareStatement("select * from goods");
            // SQL 실행
            rs = pstmt.executeQuery();

            // 데이터를 하나의 행씩 읽어서 DTO 객체로 변환해서 list에 대입
            while(rs.next()){
                GoodDTO goodDTO = new GoodDTO();
                goodDTO.setCode(rs.getString("code"));
                goodDTO.setName(rs.getString("name"));
                goodDTO.setManufacture(rs.getString("manufacture"));
                goodDTO.setPrice(rs.getInt("price"));

                list.add(goodDTO);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return list;
    }

    // goods 테이블에서 code를 가지고 데이터를 조회하기
    @Override
    public GoodDTO getGoodDTO(String code) {
        // 조회가 안된 경우는 null
        // 데이터를 1개만 꺼내올 때, 만약 1개도 없다는 것을 반환해주기 위해서 return을 기본으로 null을 줌.
        GoodDTO goodDTO = null;
        try {
            pstmt = connection.prepareStatement("select * from goods where code = ?");
            // ?에 바인딩
            // ?에 바인딩할 때 인덱스는 1부터 시작
            pstmt.setString(1, code);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                goodDTO = new GoodDTO();
                goodDTO.setCode(rs.getString("code"));
                goodDTO.setName(rs.getString("name"));
                goodDTO.setManufacture(rs.getString("manufacture"));
                goodDTO.setPrice(rs.getInt("price"));
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return goodDTO;
    };

    // 삽입 작업은 트랜잭셔늘 고려해야 한다.
    @Override
    public int insertGood(GoodDTO goodDTO){
        int result = 0;

        try{
            connection.setAutoCommit(false);

            pstmt = connection.prepareStatement(
                    "insert into goods values (?,?,?,?)"
            );

            pstmt.setString(1, goodDTO.getCode());
            pstmt.setString(2, goodDTO.getName());
            pstmt.setString(3, goodDTO.getManufacture());
            pstmt.setInt(4, goodDTO.getPrice());

            result = pstmt.executeUpdate();

            connection.commit();

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            try {
                connection.rollback();
            }catch (Exception exception){}
            e.printStackTrace();
        }

        return result;
    };
}
