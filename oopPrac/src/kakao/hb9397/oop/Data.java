package kakao.hb9397.oop;

public class Data {

    private static int sequence;
    static{
        sequence = 1;
    }
    private int num;
    private String name;

    // 매개변수 유/무에 따른 생성자를 2개 만든다(Alt + Insert - [Constructor] 이용, InteliJ)
    // 매개변수가 없는 생성자
    public Data() {
        super();
        // 인스턴스 하나를 생성하면 num에 현재 sequence를 대입하고 sequence값을 하나 증가 시킨다 AutoInrement와 유사
        num = ++sequence;
    }

    // 매개변수가 있는 생성자
    public Data(String name) {
        // 인스턴스 하나를 생성하면 num에 현재 sequence를 대입하고 sequence값을 하나 증가 시킨다 AutoInrement와 유사
        this.num = ++sequence;
        this.name = name;
    }


    // getter, setter 생성 (Alt + Insert - [Getter and Setter] 이용, InteliJ)
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

    // toString 메서드 생성( Alt+Insert - [toStirng] 이용)
    // 디버깅용 메서드
    @Override
    public String toString() {
        return "Data{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
