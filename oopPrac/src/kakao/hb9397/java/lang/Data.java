package kakao.hb9397.java.lang;

import java.util.Arrays;
import java.util.Objects;

// 하나의 데이터 묶음을 표현하기 위한 클래스
// Value Object - VO

// 자바는 복제를 이용하고자 하는 경우 clone 메서드를 재정의 해야한다.
// 재정의 할 때 Cloneable 인터페이스를 implements 하기를 권장한다.
public class Data implements Cloneable{
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

    // 복제를 위한 메서드
    public Data clone(){
        Data data = new Data();

        // 아래 방식은 얕은복사(Weak Copy)
        // num은 숫자 데이터이므로 바로 복제가 가능하다.
        // nicknames은 값이나 참조를 바로 가진 데이터가 아니고 참조안에 참조를 가진 데이터 이므로 바로 대입하면 또 생성된 인스턴스 원본의 참조가 대입된다.
        data.setNum(this.num);
        data.setName(this.name);

        // data.setNicknames(this.nicknames);


        // 반복문으로 깊은 복사
        /*
        String [] nicknames = new String[this.nicknames.length];
        for(int i=0; i < nicknames.length; i++){
            nicknames[i] = this.nicknames[i];
        }
        */

        // 배열을 복제한 후 대입하는 것이 깊은 복사
        String [] nicknames = Arrays.copyOf(this.nicknames, this.nicknames.length);
        data.setNicknames(nicknames);
        return data;
    }

    // 데이터(인스턴스)의 내용만을 비교해 같은지 확인하는 메서드
    @Override
    public boolean equals(Object other){
        boolean result = false;

        // 원래 자료형으로 변환

        Data other1 = (Data) other;

        // 숫자나 boolean 은 == 로 일치 여부를 판단하지만 그 이외 자료형은 equals로 판단.
        /*
        if(this.num == other1.getNum() && this.name.equals(other1.getName())){
            return true;
        }
        */
        // return result;

        // Objects.hash(데이터 나열)을 이용하면 데이터를 가지고 정수로 만든 HashCode를 생성한다.
        // 이렇게 만든 hashcode 값을 반환받아 비교하는 것이 직접 비교 연산을 수행하는 것보다 더 빠르다.
        return (Objects.hash(num, name)) == Objects.hash(other1.getNum(), other1.getName());



    }
}

