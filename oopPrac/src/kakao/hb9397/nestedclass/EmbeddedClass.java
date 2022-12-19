package kakao.hb9397.nestedclass;

//포함되는 클래스
public class EmbeddedClass {
    public int score;
    // 포함하는 클래스의 인스턴스 참조를 기억하기 위한 속성 생성
    private Embed embed;

    // 생성자를 이용한 주입
    // 인스턴스를 만들 때 호출
    // 속도에서 이득을 보지만 메모리 효율은 떨저짓 있음

    public EmbeddedClass(Embed embed){
        this.embed = embed;
    }

    // 주입할 때를 위한 setter 이고 필요할 때는 호출
    public void setEmbed(Embed embed){
            // 이곳에서 포함하는 클래스의 멤버를 수정할 것이다.
            this.embed = embed;
    }

    public void set(){
        // 이곳에서 포함하는 클래스의 멤버를 수정한다.
        embed.name = "독수리 다방";
        System.out.println(embed.name);
    }
}
