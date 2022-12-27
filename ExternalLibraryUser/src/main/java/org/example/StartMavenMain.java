package org.example;

public class StartMavenMain {
    public static void main(String[] args) {
        // MySQL 드라이버 로딩
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("드라이버 로드 성공");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        // 예외 발생 자바오픈소스 레포지토리에 가서 MySQL 검색하면 MySQL Connector/j 에서 version 선택 후 jar 파일 다운
    }
}
