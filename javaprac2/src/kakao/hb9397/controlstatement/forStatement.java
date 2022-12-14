package kakao.hb9397.controlstatement;

public class forStatement {
    public static void main(String[] args){
        for(int i=0, j=0; i<10 && j < 5; i++, j+=2){
            System.out.println(i);
            System.out.println(j);
        }

        String [] names = {"aespa", "redvelvet", "f(x)"};

        for(String name : names){
            System.out.println(name);
        }

        label : for(int i = 0; i < 10; i++){
            System.out.println(i);
            if( i == 3 )
                break label;
        }

        for(int i=0; i<=25; i++){
            System.out.println("*");
            if(i%5 == 0){
                System.out.println();
            }
        }
    }
}