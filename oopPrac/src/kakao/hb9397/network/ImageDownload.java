package kakao.hb9397.network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;

public class ImageDownload {
    public static void main(String[] args) {
        new Thread(){

            @Override
            public void run(){
                try{
                    // 이미지 경로
                    String addr = "https://cdn.newspenguin.com/news/photo/202208/12125_36717_2856.jpg";

                    // 확장자 추출
                    // .(dot) 을 기준으로 스플릿 할 시 \와 함께 개제해야 한다.
                    String [] temp = addr.split("\\.");
                    String ext = temp[temp.length - 1]; // 배열의 마지막 인덱스 접근
                    System.out.println(ext);

                    // 다운로드 할 이미지 경로 URL 인스턴스 생성
                    URL url = new URL(addr);

                    // url 인스턴스를 연결할 인스턴스 생성을 하는데 HttpURLConnection 이 URL 클래스의 하위 클래스이기 때문에 형 변환해서 사용한다.
                    // 상위 클래스의 요소들을 그대로 가지고 내려와서 사용할 수 있기 때문에, 반대의 경우는 불가능
                    // 하위 클래스의 더 많은 요소들은 상위 클래스에 정의 되어있지 않기 때문.
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(30000);
                    urlConnection.setUseCaches(false);

                    // 데이터를 받아오는 통로 Byte Stream 생성, 문자열을 받을 때는 BufferedReader로 변환해서 사용하지만 파일은  InputStream 그대로 사용
                    InputStream inputStream = urlConnection.getInputStream();

                    // 읽은 내용을 저장할 파일 스트림을 생성한다.
                    FileOutputStream fileOutputStream = new FileOutputStream("Dolphin." + ext);

                    // 파일이 이미 있는 경우에 대해서 처리
                    File file = new File("Dolphin." + ext);
                    if(file.exists()){
                        System.out.println("이미 존재하는 파일 입니다.");
                        return;
                    }

                    while (true) {
                        // 데이터를 저장할 Byte 배열 생성
                        byte [] raster = new byte[512];
                        int len = inputStream.read(raster);

                        if(len <= 0) { // 읽은 파일이 없다면
                            break;
                        }
                        // 읽은 내용은 파일에 기록
                        fileOutputStream.write(raster, 0, len);
                    }

                    // 사용 자원 해제
                    inputStream.close();
                    fileOutputStream.close();
                    urlConnection.disconnect();

                } catch (Exception e){
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }.start();

    }
}

