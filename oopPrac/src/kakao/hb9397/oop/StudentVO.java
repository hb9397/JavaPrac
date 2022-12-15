package kakao.hb9397.oop;

public class StudentVO {
    private int num;
    private String name;
    private String email;
    private String nickname;
    private boolean married;

    // getter
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isMarried() {
        return married;
    }

    // setter
    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}
