package com.example.javaweb2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "*.jsp")
public class LogFilter implements Filter {

    // 메모리 할당 후 처음 사용될 때 호출되는 초기화 메서드
    public void init(FilterConfig config) throws ServletException {
    }

    // 필터가 파괴될 때 호출되는 메서드
    public void destroy() {
    }


    // URL 에 해당하는 요청이 왔을 때 호출되는 메서드
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 해당 영역에 작성하면 Controller 가 처리하기 전애 수행된다.
        System.out.println("Controller가 처리하기 이전");

        // 자동으로 생성되는 메서드
        chain.doFilter(request, response);

        // 해당영역은 Controller가 처리한 뒤에 수행될 내용이다.
        System.out.println("Controller가 처리한 후");
    }
}
