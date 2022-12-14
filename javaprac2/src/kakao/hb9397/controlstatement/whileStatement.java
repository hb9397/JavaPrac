package kakao.hb9397.controlstatement;

public class whileStatement {
    public static void main(String[] args){
        int i = 0;
        int total1 = 0;
        while(i <= 10){
            total1 = total1 + i;
            i++;
        }
        System.out.println("1부터 10까지의 합은 " + total1); // 55
        System.out.println("while 문이 종료된 후의 i의 값: " + i); // 11

        int j = 0;
        int total2 = 0;
        do{
            total2 = total2 + j;
            j++;
        }while(j <= 10);
        System.out.println("1부터 10까지의 합은 " + total2); // 55
        System.out.println("while 문이 종료된 후의 j의 값: " + j); // 11
    }
}
