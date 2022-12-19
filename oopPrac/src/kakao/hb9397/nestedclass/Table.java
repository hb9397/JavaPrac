package kakao.hb9397.nestedclass;

// 현재 Table 클래스는 SQL에서 Create Table 테이블명 num 칼럼추가, autoincrement한 것.
public class Table {
    private static int sequence; // 일렵번호
    private static int step = 1; // Oracle은 다음과 같이 스탭이 있지만, MySQL에는 없다.


    // getter, setter 생성 - getter는 현재값을 확인, setter는 수정하기 위한 메서드
    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Table.sequence = sequence;
    }

    public static int getStep() {
        return step;
    }

    public static void setStep(int step) {
        Table.step = step;
    }

    // 인스턴스가 별도로 소유
    private int num;

    public Table() {
        sequence += step;
        num = sequence;
    }

    // getter만 만드는 것은 해당 클래스의 인스턴스 중 해당되는 속성은 읽기만 가능하도록 하는 것.
    public int getNum() {
        return num;
    }
}
