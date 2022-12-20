package kakao.hb9397.java.util;

public class VO implements Comparable<VO>{ // Comparable은 Generic 이므로 현재 Class의 자료형을 미지정 자료형에 알려야 한다.
    private int num;
    private  String name;
    private int age;

    public VO() { // 기본 생성자
        super();
    }

    public VO(int num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }


    // getter & setter
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "VO{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    // Comparable 인터페이스 가지고 있는 compareTo 메서드를 재정의 하지않으면 컴파일 에러 발생
    @Override
    public int compareTo(VO o) {
        // 나이 오름 차순 정렬
        // 숫자 기준은 뺄셈을 해서 반환하면 되고 순서를 바꾸면 내림차순으로 정렬된다.
        // return this.age - o.age;

        // 문자열은 뺄셈이 안된다, 하지만 String은 compareTo가 이미 재정의 되어 있기 때문에 아래와 같이 사용하면 오름차순 정렬이 된다.
        // 순서를 바꾸면 내림차순
        return this.name.compareTo(o.name);
    }
}
