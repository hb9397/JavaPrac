package kakao.hb9397.exceptionhandling;

public class ExceptionHandling {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        // System.out.println(i / j);
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at kakao.hb9397.exceptionhandling.ExceptionHandling.main(ExceptionHandling.java:7)
        // 예외 발생

        try {
                System.out.println(i / j);
        }
        // catch 가 여러개면 일치하는 catch 블럭의 내용을 처리하고 다른 catch는 모두 Pass 한다.
        // 상위 클래스의 참조형 변수에는 하위 클래스 인스턴스 참조를 저장할 수 있기 때문에 catch를 여러 개 작성할 때 주의 해야 한다.
        // ArithmeticException이나 NullPointerException은 Exception의 하위 클래스 이기 때문
        // 상위 클래스의 예외 처리 구문을 먼저 만들면 아래 예외 처리 구문이 DeadCode가 될 가능성이 있기 때문에 컴파일 에러가 발생한다.
        /*
        catch (Exception e){

            System.out.println();
        }
        */

        catch(ArithmeticException e){ // 앞서 바로 i/j를 수행한 결과 발생하는 에러가 ArithmeticException
            // 예외가 발생했을 때 수행할 내용
            // 예외가 발생하지 않으면 수행되지 않는다.
            System.out.println("0으로 나누면 안된다.");
        }
        catch (NullPointerException e) {
            System.out.println("Null이 속성이나 메서드를 호출하면 발생하는 예외다.");
        }
        finally {
            // 예외 발생 여부에 상관없이 수행되는 내용
            System.out.println("예외 발생 여부에 상관없이 수행된다.");
        }

    }
}
