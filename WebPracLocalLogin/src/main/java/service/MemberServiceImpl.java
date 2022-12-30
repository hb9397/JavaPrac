package service;

import domain.MemberVO;
import dto.MemberDTO;
import persistence.MemberDAO;

public class MemberServiceImpl implements MemberService{
    // DAO 변수
    // Service 는 DAO 를 주입 받아야 한다.
    private MemberDAO memberDAO;

    private MemberServiceImpl() {
        memberDAO = MemberDAO.getInstance();
    }

    private static MemberService service;

    public static MemberService getInstance() {
        if (service == null) {
            service = new MemberServiceImpl();
        }
        return service;
    }
    @Override
    public MemberDTO login(String mid, String mpw) {
        MemberDTO dto = null;
        MemberVO vo = memberDAO.login(mid, mpw);
        // vo를 dto로 변환
        if (vo != null) {
            dto = new MemberDTO();
            dto.setMid(vo.getMid());
            dto.setMname(vo.getMname());
        }
        return dto;
    }
}