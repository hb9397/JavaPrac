package kakao.hb9397.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AsyncStringDownload {
    public static void main(String [] args){
        // 스레드를 만들어서 다운로드 하기 -> 비동기 방식
        new Thread() {
            @Override
            public void run(){
                try {
                    // URL 을 생성한다.
                    URL url = new URL("https://www.kakao.com");

                    // 연결을 위한 객체 생성
                    HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

                    // 연결을 위한 옵션 설정
                    urlConnection.setConnectTimeout(10000);
                    urlConnection.setUseCaches(false);
                    urlConnection.setRequestMethod("GET");

                    // 전송받은 데이터를 읽기 위한 Stream 생성
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                    StringBuilder stringBuilder = new StringBuilder();

                    while (true){
                        String line = bufferedReader.readLine();
                        if(line == null){
                            break;
                        }
                        stringBuilder.append(line + "\n");
                    }
                    String html = stringBuilder.toString();
                    System.out.println(html);

                    // 사용중인 자원해제
                    bufferedReader.close();
                    urlConnection.disconnect();

                }catch (Exception e){
                    System.out.println(e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
