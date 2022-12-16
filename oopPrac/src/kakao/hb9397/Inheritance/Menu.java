package kakao.hb9397.Inheritance;

public interface Menu {
    //Interface에는 추상메서드와 default 메서드
    // pubulic void Menu() { } -> {} 구현 하겠다는 것으로 인지하고 에러 발생

    public void login(String id, String password); // 과 같이 추상 메서드 작성

    public default boolean joinSucess(){ // 혹은 default method 생성 가능
        System.out.println("성공");
        return true;
    }
}
