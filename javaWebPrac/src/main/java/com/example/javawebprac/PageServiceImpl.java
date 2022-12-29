package com.example.javawebprac;

public class PageServiceImpl implements PageService{
    // Java 에서는 싱글톤 패턴 작성 코드를 추가해야 하지만 Spring 에서는 불필요하다.

    public int add(int first, int second){
      return first + second;
    }
}
