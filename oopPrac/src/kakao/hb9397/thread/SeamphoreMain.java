package kakao.hb9397.thread;

import java.util.concurrent.Semaphore;

class SemaphoreThread implements Runnable{
    private Semaphore semaphore;
    private String message;

    public SemaphoreThread(Semaphore semaphore, String message){
        this.semaphore = semaphore;
        this.message  = message;
    }

    @Override
    public void run() {
        try{
            // 항상 공유 자원을 사용하기 전에 acuire()을 호출한다.
            semaphore.acquire();
            System.out.println(message);
            Thread.sleep(5000);
        } catch(Exception e){}

        // 공유 자원 해제
        semaphore.release();
    }
}
public class SeamphoreMain {
    public static void main(String[] args){
        // 동시에 실행될 수 있는 스레드의 개수를 설정하는 클래스 semaphore
        // 동시에 여러 개의 스레드가 수행될 상황에서 성능 저하를 막기 위해서 사용한다.
        // 아래에서는 semaphore를 3으로 지정해 두었기 때문에 최대 동시에 3개의 Thread만 처리를 한다.
        Semaphore semaphore = new Semaphore(3);

        new Thread(new SemaphoreThread(semaphore, "1")).start();
        new Thread(new SemaphoreThread(semaphore, "2")).start();
        new Thread(new SemaphoreThread(semaphore, "3")).start();
        new Thread(new SemaphoreThread(semaphore, "4")).start();
        new Thread(new SemaphoreThread(semaphore, "5")).start();

    }
}
