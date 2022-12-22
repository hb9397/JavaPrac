package kakao.hb9397.thread;

class ShareData implements Runnable{
    private int result; // 합계를 구할 때
    private int idx; // 합계를 구할 때 사용할 인덱스

    public int getResult(){
        return result;
    }

    // idx 값을 1씩 증가 하면서 result에 더해 줄 메서드
    // private synchronized void sum() { // -> 메서드 전체를 동기화 하기 보다는 실제 데이터 수정하는 부분만을 동기화하는 것이 공유도가 높다.
    private synchronized void sum() {
        for(int i = 0; i < 1000; i++){

            // 이 영역 내에서 다른 작업이 this를 사용할 수 없도록 한다.
            synchronized (this) {
                idx = idx + 1;
                try {
                    Thread.sleep(1);
                }catch (Exception e) {}
                result = result + idx;
            }
        }
    }


    // Thread로 동작할 메서드 구현 (Runnable 인터페이스를 implements 받을 때 반드시 재 정의해서 사용해야 한다.)
    @Override
    public void run() {
        sum();
    }
}

public class MutexMain {
    public static void main(String[] args){
        ShareData data = new ShareData();

        // 값이 랜덤인 것도 반복문을 손댄적도 없지만 두개의 스레드를 사용했을 때 출력값이 계속 상이하게 된다.
        Thread th1 = new Thread(data);
        th1.start();

        Thread th2 = new Thread(data);
        th2.start();

        try{
            // Thread는 제어권을 넘겨버릴 수 있기 때문에 Try Catch문으로 잡아서 사용하는 것이 바람직하다.
            Thread.sleep(5000);
            System.out.println(data.getResult());
        } catch(Exception e){}
    }
}
