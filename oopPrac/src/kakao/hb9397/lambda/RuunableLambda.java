package kakao.hb9397.lambda;

public class RuunableLambda {
    public static void main(String [] args){
        // Runnable 인터페이스를 이용한 스레드 생성
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    try {
                        Thread.sleep(1000);
                        System.out.println("일반적인 Runnable 인터페이스를 사용한 스레드 생성");
                    }catch (Exception e){
                        System.out.println(e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // Lambda를 이용한 Runnable 인터페이스 사용 스레드 생성
        new Thread(() -> {
            for(int i=0; i< 10; i++){
                try{
                    Thread.sleep(1000);
                    System.out.println("Lambda 와 Runnable 인터페이스를 이용한 스레드 생성");
                } catch (Exception e){
                    System.out.println(e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
