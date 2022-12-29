package com.example.javawebprac;

// 사용자의 요청을 처리할 메서드의 원형을 가진 인터페이스
public interface PageService {
    // 2개의 정수를 받아서 더 한 후 반환하는 메서드
    public int add(int first, int second);
}
