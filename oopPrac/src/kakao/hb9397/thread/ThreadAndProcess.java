package kakao.hb9397.thread;

public class ThreadAndProcess {
    public static void main(String [] args){
        // thread 를 사용하지 않은 경우
//        new Thread() {
//            public void run(){
//                for(int i=0; i<10; i++){
//                    try{
//                        Thread.sleep(1000);
//                        System.out.println(i);
//                    }catch (Exception e){
//
//                    }
//                }
//            }
//        }.run();
//
//        new Thread() {
//            public void run(){
//                for(int i=0; i<10; i++){
//                    try{
//                        Thread.sleep(1000);
//                        System.out.println(i);
//                    }catch (Exception e){
//
//                    }
//                }
//            }
//        }.run();

        new Thread() {
            public void run(){
                for(int i=0; i<10; i++){
                    try{
                        Thread.sleep(1000);
                        System.out.println(i);
                    }catch (Exception e){

                    }
                }
            }
        }.start();

        new Thread() {
            public void run(){
                for(int i=0; i<10; i++){
                    try{
                        Thread.sleep(1000);
                        System.out.println(i);
                    }catch (Exception e){

                    }
                }
            }
        }.start();
    }
}
