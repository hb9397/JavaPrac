package org.example.superCSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoLibraryCSVMain {
    public static void main(String[] args) {
        // 파일의 내용을 읽기 위해서 try with resource ~ catch 문으로 처리
        // 문자열 파일을 읽기 위한 스트림 생성
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("./volley.csv"))))
        {
            // 첫줄 제외를 위한 변수 생성
            boolean flag = false;

            // 파싱한 데이터의 겯과를 저장하기 위한 List
            List<Player> list = new ArrayList<>();

            while(true){
                // 입력받은 파일의 내용을 한줄 씩 출력하기
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                // 첫줄 제외를 위한 제어문
                if(flag == false){
                    flag = true;
                    continue;
                }
                // System.out.println(line);
                // , 기호로 분할'
                String [] ar = line.split(",");
                System.out.println(ar[0]);

                Player player = new Player();
                player.setName(ar[0]);
                player.setAge(Integer.parseInt(ar[1]));


                String birth = ar[2];
                // Player 클래스의 인스턴스가 가진 날짜형식의 문자열을 Date 타입으로 변환해서 대입하낟.
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse(birth);
                 player.setBirth(date);

                 player.setEmail(ar[3]);
                 player.setNickname(ar[4]);

                 list.add(player);
            }
            for (Player player : list) {
                System.out.println(player);
            }

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
