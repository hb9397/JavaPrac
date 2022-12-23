package kakao.hb9397.io;

import java.io.*;

public class SerializableMain {
    public static void main(String [] args){
        // 인스턴스 단위로 기록할 수 있는 스트림 생성
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sample.dat"))){
            // 기록할 인스턴스 생성
            Data data = new Data(1, "adam", "군계");
            oos.writeObject(data);
            oos.flush();
        }catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        // 인스턴스 단위로 읽을수 있는 스트림 생성
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sample.dat;'?>"))){
            // 기록된 인스턴스 읽어오기
            // retur type Ojbect
            Data data = (Data)ois.readObject();
            System.out.println(data);
        }catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
