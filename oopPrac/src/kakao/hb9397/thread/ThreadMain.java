package kakao.hb9397.thread;


public class ThreadMain {
    public static void main(String[] args){

        Thread th1 = new Thread(){
            @Override
            public void run(){
                // 무한 반복
                while(true){
                    try{
                        Thread.sleep(1000);
                        System.out.println("th1" + getName());
                    } catch (Exception e){}
                }
            }
        };

        Thread th2 = new Thread(){
            @Override
            public void run(){
                // 무한 반복
                while(true){
                    try{
                        Thread.sleep(1000);
                        System.out.println("th2" + getName());
                    } catch (Exception e){}
                }
            }
        };

        Thread th3 = new Thread(){
            @Override
            public void run(){
                // 무한 반복
                while(true){
                    try{
                        Thread.sleep(1000);
                        System.out.println("th3" + getName());
                    } catch (Exception e){}
                }
            }
        };

        th1.setDaemon(true);
        th1.start();

        // 정확한 순서는 알 수 없어도 대략적인 순위와 사용빈도에 따라 자주 실행될 가능성이 높음
        th2.setPriority((Thread.MIN_PRIORITY));
        th3.setPriority((Thread.MIN_PRIORITY));


        th2.start();
        th3.start();

        // 3초 후 강제로 예외 발생 시키기
        // NullPointerException
        // 그러나 threed 는 예외 발생과 상관 없이 계속 실행되는 것을 알 수 있다.
        // Daemon이 아닌 스레드는 다른 스레드가 중지되더라도 계속 동작한다.

        // String str = null;
        // System.out.println(str.trim());

        // Line 20과 같이 Therad를 Daemon으로 설정하면
        // 다른 스레드가 동작 중이 아니면 자동으로 종료되도록 설정하는 것이기 때문에 예외가 발생하게 되면 Daemon 스레드도 종료된다.

    }
}
