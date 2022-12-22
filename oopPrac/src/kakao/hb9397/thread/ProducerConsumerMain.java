package kakao.hb9397.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Product{
    // 공유 자원
    // 실제로 사용할 공유 자원 List
    List<Character> list;

    public Product(List<Character> list){
        this.list = list;
    }

    // 공유 자원에 데이터를 삽입하는 메서드
    synchronized public void put(char ch){
        list.add(ch);
        System.out.println(ch + "를 입고");
        try{
            Thread.sleep(1000);
        } catch (Exception e) {}
        System.out.println("제고 수량:" + list.size());

        // 대기중인 스레드가 작업을 수행하도록 신호를 전송한다.
        notify();
    }

    // 공유 자원을 소비하는 메서드
    synchronized public void get() {
        // 생산자 스레드에서 데이터를 만들지 않았을 때 소비자 스레드는 Waiting 상태로 전환하기 위한 처리 추가
        if(list.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // 첫번째 데이터 꺼내기
        Character ch = list.remove(0);
        System.out.println(ch + "를 출고");
        try{
            Thread.sleep(1000);
        } catch(Exception e) {}

        System.out.println("재고 수량:" + list.size());
    }
}

// 생산자 스레드
class Producer extends Thread{
    private Product product;
    public Producer(Product product){
        this.product = product;
    }

    // 스레드로 수행할 내용
    public void run() {
        for(char ch = 'A'; ch <= 'Z'; ch++){
            product.put(ch);
        }
    }
}

// 소비자 스레드
class Customer extends Thread{
    private Product product;

    public Customer(Product product){
        this.product = product;
    }

    public void run() {
        for(int i = 0; i < 26; i++){
            product.get();
        }
    }
}

public class ProducerConsumerMain {
    public static void main(String[] args){
        // 공유 자원 생성
        List <Character> list = new ArrayList<>();
        Product product = new Product(list);

        // 공유 자원을 함께 사용하는 생산자와 소비자 스레드 생성
        Producer producer = new Producer(product);
        Customer customer = new Customer(product);

        // 스레드 시작
        producer.start();
        customer.start();
    }
}
