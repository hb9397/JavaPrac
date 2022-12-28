package org.example.mariadbconnect;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MariaDBConnectMain {
    public static void main(String[] args) {
        // 1. DB 드라이버 로드
        // 드라이버 의존성을 설정하지 않거나 클래스 이름이 틀리면 얘외가 발생한다.
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 로드 성공");
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        // 2. DB 접속 - java.sql.Connection
        try(Connection connection =
                    DriverManager.getConnection(
                                    "jdbc:mariadb://127.0.0.1:3306", "root", "8236"))
        {
            System.out.println(connection);

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
