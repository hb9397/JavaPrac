package kakao.hb9397.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class KakaoBookSearchAPI {
    public static void main(String[] args){
        // 카카오 도서 검색 API
        new Thread(new Runnable() {
            @Override
            public void run() {

                try{

                    // url 만들기
                    // GET 방식에서는 반드시 Parameter를 인코딩 해야한다.
                    String address = "https://dapi.kakao.com/v3/search/book?target=title";
                    address += "&query=";
                    address += URLEncoder.encode("삼국지", "utf8");

                    // URL에 대한 인스턴스 만들기
                    URL url = new URL(address);

                    // URL과 현재 Java 클래스와 연결할 인스턴스를 만드는데 URL이 하위 클래스로 HttpURLConnection으로 형 변환해서 사용
                    HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();

                    urlConnection.setConnectTimeout(30000);
                    urlConnection.setUseCaches(false);
                    urlConnection.setRequestMethod("GET");

                    // Kakao 검색 API를 사용하기 위해 API Key와 Value를 설정
                    urlConnection.setRequestProperty("Authorization",  "KakaoAK 38f43ff5aee9ea89cc35c4503953906c");

                    // 데이터 읽어오기
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                    // 받아온 데이터를 한줄씩 받아와서 문자열로 변환 후 출력
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true){
                        String imsi = bufferedReader.readLine();
                        if(imsi == null){
                            break;
                        }
                        stringBuilder.append(imsi + "\r\n");
                    }
                    String result = stringBuilder.toString();
                    System.out.println(result);

                    // 자원 해제
                    bufferedReader.close();
                    urlConnection.disconnect();
                } catch (Exception e){
                    System.out.println(e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
