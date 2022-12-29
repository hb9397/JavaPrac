package com.example.javawebprac;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PageController", value = "/pageController")
public class PageController extends HttpServlet {

    // 서비스에 대한 참조 변수
    private PageService pageService;

    public PageController(){
        // 생성자에서 서비스를 생성하고 나중에 주입 받는다.
        pageService = new PageServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // process.jsp 에서 수행했던 get 요청을 처리한다.
        // 파라미터 읽기
        String first = request.getParameter("first");
        String second = request.getParameter("second");

        // 서비스 메서드 호출
        // 파라미터의 자료형 변환은 Service에서 수행해도 되지만 Spring은 일반적으로 Controller에서 수행하기 때문에
        // Controller에서 수행한 것
        int result = pageService.add(Integer.parseInt(first), Integer.parseInt(second));

        // 결과를 저장
        request.setAttribute("result", result);

        // 서블릿에서는 session을 만들어서 사용해야 한다.
        request.getSession().setAttribute("result", result);

        // application 객체
        request.getServletContext().setAttribute("result", result);

        // View 페이지와 출력 방식 설정 후 데이터 전달
        response.sendRedirect("output.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
