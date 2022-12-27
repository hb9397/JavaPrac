package org.example.jsonParse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class JSONCreate {
    public static void main(String[] args) {
        // VO 클래스를 이용
        ToDoVO vo1 = new ToDoVO(1, 1, "한글",true);
        ToDoVO vo2 = new ToDoVO(2, 2, "English",false);
        ToDoVO vo3 = new ToDoVO(3, 3, "일본어",false);
        ToDoVO vo4 = new ToDoVO(4, 4, "중국어",true);


        // 저장할 JSON 파일을 생성한다
        File file = new File("./todo.json");

        // JSON 기록을 위한 인스턴스를 생성한다
        ObjectMapper mapper = new ObjectMapper();

        // 기록을 위해서는 try ~ catch 를 해야 한다.
        try{
            mapper.writeValue(file, Arrays.asList(vo1, vo2, vo3 ,vo4));
        }catch (Exception e){
            System.out.println("기록 실패");
        }
    }
}
