package org.example.jsonParse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParseMain {
    public static void main(String[] args) {
        // 데이터 다운로드
        // 다운로드 받은 문자열을 저장하기 위한 변수 json
        String json = null;
        try {
            // 데이터 다운로드를 받기 위한 URL 인스턴스 생성
            // 한글의 유무를 확인하는 것이 먼저다
            // 한글이 포함 되어 있다면 그 부분은 URLEncoder.encode 메서드를 이용해서 인코딩한 후 생성한다.
            URL url = new URL("https://jsonplaceholder.typicode.com/todos");

            // URL 과 연결할 HttpURLConnection 인스턴스를 URL 인스턴스의 참조를 형 변환해서 생성
            // HttpURLConnection 이 URL 클래스 보다 상위 클래스
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // 옵션 설정
            urlConnection.setRequestMethod("GET"); // HTTP 요청 방식
            urlConnection.setConnectTimeout(30000); // 접속 제한 시간
            urlConnection.setUseCaches(false); // 캐싱된 데이터 사용 여부

            // 문자열을 읽기 위한 스트림을 생성한다.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()
            ));

            // 많은 양의 문자열 읽기
            StringBuilder stringBuilder = new StringBuilder();
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                stringBuilder.append(line + "\n");
            }
            json = stringBuilder.toString();
            System.out.println(json);


        } catch (Exception e){
             System.out.println("데이터 다운로드 실패");
             System.exit(0); // 프로그램 종료
             return; // main Method 종료
        }

        // 다운로드 받은 데이터 파싱

        // 파싱한 결과를 사용(출력만)
    }
}
