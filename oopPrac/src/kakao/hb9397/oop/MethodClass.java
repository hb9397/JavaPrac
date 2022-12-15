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
    // static 인스턴스를 생성할 필요가 없음
    // 매개변수가 없다.
    // MethodClass.noArgsMthod()로 호출하면 된다.
    public static void noArgsMethod(){
        for(int i=0; i<5; i++){
            System.out.println("noArgsMethod");
        }
    }
    // 매개변수가 정수 1개인 메서드 생성
    // MethodClass.oneArgsMethod(n) 으로 호출
    public static void oneArgsMethod(int n){
        for(int i=0; i<n; i++){
            System.out.println("oneArgsMethod");
        }
    }

    // 매개변수가 2개인 메서드
    // Java 에서는 매개변수가 2개 이상인 경우에 순서대로 대입해야 한다.
    public static void twoArgsMethod(int n, String msg){
        for(int i=0; i<n; i++){
            System.out.println(msg);
        }
    }


    // return이 없는 메서드는 연속해서 호출하는 것이 불가능하다
    // 2개의 정수를 받아 더해주는 메서드
    // 인스턴스.addWithInteger(정수1, 정수2)로 호출
    // 화면에 출력할 수 있으나 값을 재사용할 수 는 없다
    public void addWithInteger(int first, int second){
        System.out.println("결과: " + (first+second));
    }

    // return이 있는 인스턴스 메서드 생성
    public int addWithInteger1(int first, int second){
        int result = first + second;
        return result;
    }

    // 메서드 오버로딩
    public void display(){

    }

    // 매개변수의 개수가 달라서 오버로딩
    public void display(int a){

    }

    // 매개변수의 개수는 같지만 자료형이 다르기 때문에 오버로딩
    public void display(double a){

    }

    // 매개변수가 기본현 1개일 때
    // 내부에서 매개변수의 값을 수정해도 넘겨준 데이터는 변하지 않는다
    public static void callByValue(int n) {
        n =  10;
        System.out.println("n: " + n);

    }

    // 매개변수가 참조형인 경우
    public static void callByReference(int[] ar){
        ar[0] = ar[0] + 1;
        System.out.println("ar[0]" + ar[0]);
    }

    public int score = 100;
    public void thisMethod(){
        int score = 200;

        // Scope의 법칙이 적용되어 가까이에서 만든 score 200을 사용하게 된다.
        System.out.println("score: " + score);

        // 이 때 인스턴스가 가진 score 100을 호출하려면
        // this 가 붙으면 메서드 안에서 찾지 않는다.
        System.out.println("this.score: " + this.score);
    }

    // 재귀를 사용하지 않은 피보나치
    public static int noRecursionFibonacci(int n) {
        int fibo = 0; // 현재 구하고자 하는 피보나치 값
        int n_1 = 1; // 현재 구하고자 하는 피보나치값의 바로 앞
        int n_2 = 1; // 현재 구하고자하는 피보나치 값의 두번째 앞

        // 규칙이 3번째 부터 적용된다.
        int i = 3;
        while(i <= n){
            fibo = n_1 + n_2;

            // n_1과 n_2를 이동
            n_2 = n_1;
            n_1 = fibo;

            i++;
        }
        return fibo;
    }

    // 재귀를 이용한 피보나치
    public static int recursionFibonacci(int n){
        if(n == 1 || n == 2){
            return 1; // 피보나치의 첫번째, 두번째 항은 1이다.
        }
        //
        return recursionFibonacci(n-1) + recursionFibonacci(n-2);
    }

    // 매개변수의 개수를 가변으로 설정한 메서드
    public static void display(String ...args){
        for(String temp: args){
            System.out.println(temp);
        }
    }

}
