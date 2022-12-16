package kakao.hb9397.Inheritance;

public class InheritanceMain {
    public static void main(String[] args){
        Sub sub = new Sub();

        // Sub가  Super를 상속받기 때문에 Sub에 만들지 않았던 setNum과 setName을 사용할 수 있다.
        // getter 메서드도 마찬가지
        sub.setNum(1);
        sub.setName("adam");
        sub.setNickname("군계");

        System.out.println(sub); // num과 name은 상위 클래스에서
    }
}
