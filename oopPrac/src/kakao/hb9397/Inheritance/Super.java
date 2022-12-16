package kakao.hb9397.Inheritance;

public class Super {
    private int num; // 상속은 되지만 하위 클래스에서 접근할 수 없음
    protected String name;

    public Super(int num, String name){
        this.num = num;
        this.name = name;
    }

    // Sub에서 상속받고 있기 때문에 위처럼 매개변수를 받는 생성자를 만들시 기본 생성자가 소멸되기 때문에
    // 기본 생성자를 따로 만들어주어야 Sub 클래스에서 에러가 발생하지 않는다.
    public Super() {
        super();
    }

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

    @Override
    public String toString() {
        return "Super{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
