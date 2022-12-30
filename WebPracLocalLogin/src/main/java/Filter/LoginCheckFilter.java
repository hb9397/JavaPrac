package Filter;

import dto.MemberDTO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    private MemberService memberService;

    public LoginCheckFilter() {
        memberService = MemberServiceImpl.getInstance();
    }


    // 메모리 할당 후 처음 사용될 때 호출되는 초기화 메서드
    public void init(FilterConfig config) throws ServletException {
    }

    // 필터가 파괴될 때 호출되는 메서드
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        // 해당 영역에 작성하면 Controller 가 처리하기 전애 수행된다.

        // request 와 response 형 병환
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Login 요청이 오면(Edit Configure 에서 프로젝트 path를 /로 설정해서 바로 login 페이지를 걸면 된다.
        if(req.getRequestURI().equals("/login")){

            // 로그인 요청이 오면 쿠키를 전부 읽는다.
            Cookie [] cookies = req.getCookies();

            for(Cookie cookie:cookies){
                if(cookie.getName().equals("remember-me")){ // Controller에서 발급한 uuid 와 같아야한다.
                    String uuid = cookie.getValue();
                    MemberDTO dto = memberService.login(uuid);
                    req.getSession().setAttribute("logininfo", dto);

                    // 메인 페이지로 redirect
                    res.sendRedirect("./");
                    return;
                }
            }
        }

        chain.doFilter(request, response);

        // 해당영역은 Controller가 처리한 뒤에 수행될 내용이다.
    }
}
