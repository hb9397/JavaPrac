package org.example.jsonParse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
            // URL이 HttpURLConnection 클래스 보다 상위 클래스이기 때문에 다운 캐스팅하는 것이 가능함.
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // 옵션 설정
            urlConnection.setRequestMethod("GET"); // HTTP 요청 방식
            urlConnection.setConnectTimeout(30000); // 접속 제한 시간
            urlConnection.setUseCaches(false); // 캐싱된 데이터 사용 여부

            // KaKao 와 같은 OpenAPI 들은 Key를 요구하는 경우에는
            // urlConnection.setRequestProperty(Key 이름, 실제 Key);
            // 와 같이 사용하면 된다.

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
            // System.out.println(json);


        } catch (Exception e){
             System.out.println("데이터 다운로드 실패");
             System.exit(0); // 프로그램 종료
             return; // main Method 종료
        }

        // 다운로드 받은 데이터 파싱
        // 파싱한 json 문자열을 요소로 저장할 ArrayList 생성
        List<ToDoVO> list = new ArrayList<>();
        try{
            if(json != null){
                // 전체 문자열을 배열로 변환
                JSONArray jsonAr = new JSONArray(json);

                // 배열을 순회
                for(int i = 0; i < jsonAr.length(); i++){
                    // 배열의 요소를 JSON 객체로 가져오기
                    JSONObject jsonObj = jsonAr.getJSONObject(i);
                    // System.out.println(jsonObj);

                    ToDoVO vo = new ToDoVO();

                    // 객체는 Key를 이용해서 가져온다
                    vo.setUserid(jsonObj.getInt("userId"));
                    vo.setId(jsonObj.getInt("id"));
                    vo.setTitle(jsonObj.getString("title"));
                    vo.setCompleted(jsonObj.getBoolean("completed"));

                    list.add(vo);
                }
            }
        }catch (Exception e){
            System.out.println("파싱 실패");
            System.out.println(e.getLocalizedMessage());
        }


        // 파싱한 결과를 사용(출력만)
        for(ToDoVO vo : list){
            System.out.println(vo);
        }
    }
}
