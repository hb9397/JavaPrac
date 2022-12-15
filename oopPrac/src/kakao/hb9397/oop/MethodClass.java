package kakao.hb9397.oop;

import javax.swing.*;

public class MethodClass {

    private static int num;
    private String name;

    // static method
    public static void method1(){
        num = 1;
        // Static 메서드에서 instance 속성에 접근 할 수 없다.
        // name = "adam"
        System.out.println("Static Method");
    }

    // instance method
    public void method2(){
        // instance 메서드에서는 intance 속성에 instance의 this로 인해 접근이 가능하다.
        num = 1;
        name = "adam";
        System.out.println("Instance Method");
    }
}
