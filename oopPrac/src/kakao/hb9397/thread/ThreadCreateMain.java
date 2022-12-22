package kakao.hb9397.thread;

// 초급 프로그래밍에서는 써봤자 네트워크를 통해 다운로드 받을 때 정도이며, 바로 시분할 프로그래밍을 하기에는 까다롭다.
// Thread 클래스로부터 상속받는 클래스, 클래스를 만들면 Static 메모리 영역에 상주하게 되어있다.
class ThreadEx extends Thread{

    @Override
    public void run(){
        // 1초 마다 스레드 이름을 10번 출력하도록 설정
        for(int i=0; i<10; i++){
            try{
                Thread.sleep(1000);
                System.out.println(getName());
            } catch(Exception e){

            }
        }
    }
}

public class ThreadCreateMain {
    public static void main(String[] args){
        // 클래스를 상속받은 경우 대부분의 경우는 변수를 만들 때 상위 클래스 이름을 사용한다.
        // 이렇게 하면 상속받은 하위 클래스의 인스턴스임을 알릴 수 있기 때문에 가독성을 높일 수 있어서 이런 방식으로 사용한다.
        Thread th1 = new ThreadEx();
        th1.start();

        // anonymous Class를 이용해서 순간적으로 1번만 만들기
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // 1초 마다 스레드 이름을 10번 출력하도록 설정
                for(int i=0; i<10; i++){
                    try{
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch(Exception e){

                    }
                }
            }
        };
        Thread th2 = new Thread(r);
        th2.start();
    }
}
