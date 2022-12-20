package kakao.hb9397.java.lang;

import java.util.Arrays;

// 하나의 데이터 묶음을 표현하기 위한 클래스
// Value Object - VO
public class Data {
    private int num;
    private String name;
    private String[] nicknames;

    // Default Constructor

    public Data() {

    }

    // 속성을 대입 받아서 생성하는 생성자
    // 인스턴스를 빠르게 초기화 하기 위해서 사용한다.
    public Data(int num, String name, String[] nicknames) {
        this.num = num;
        this.name = name;
        this.nicknames = nicknames;
    }

    // 접근자 메서드(getter, setter)

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNicknames() {
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }


    // 인스턴스의 내용을 빠르게 만들기 위해서 사용한다.(출력을 빠르게 하기 위해서 사용한다.)
    // 디버깅을 위한 메서드라고 한다.
    @Override
    public String toString() {
        return "Data{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nicknames=" + Arrays.toString(nicknames) +
                '}';
    }
}

