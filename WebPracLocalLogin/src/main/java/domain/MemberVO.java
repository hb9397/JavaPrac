package domain;

public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;

    public MemberVO() {
        super();
    }

    public MemberVO(String mid, String mpw, String mname) {
        this.mid = mid;
        this.mpw = mpw;
        this.mname = mname;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpw() {
        return mpw;
    }

    public void setMpw(String mpw) {
        this.mpw = mpw;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "memberVO{" +
                "mid='" + mid + '\'' +
                ", mpw='" + mpw + '\'' +
                ", mname='" + mname + '\'' +
                '}';
    }


}
