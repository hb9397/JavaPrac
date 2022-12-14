package kakao.hb9397.controlstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args){
        // BufferedReader 를 이용한 숫자와 문자열 입력받기
        // 아래와 같이 BufferedReader를 사용하면 별도로 종료해줘야 한다.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            System.out.print("이름을 입력하세요 : ");
            String name = br.readLine();
            System.out.println(name);

            System.out.print("나이름 입력하세요 : ");
            String stringAge = br.readLine();
            int intAge = Integer.parseInt(stringAge);
            System.out.println(intAge);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

//        Scanner sc = new Scanner(System.in); // Scanner 객체는 종료해주지 않으면 메모리 누수가 발생할 가능성이 높다.
//        int age = sc.nextInt();
//        sc.close();

        try{
            Scanner sc = new Scanner(System.in);
            //System.out.print("이름을 입력하세요: ");
            //String name = sc.nextLine();
            //System.out.print("나이를 입력하세요: ");
            //int age = sc.nextInt();

            // 숫자를 먼저 입력 받고 문자열을 입력받는 경우 nextInt()에서 앞서 숫자 뒤에 오는 Enter를 입력 받지 못해서
            // 뒤의 nextLine()에서 Enter를 받아와 버리기 때문에 중간에 nextLine()하나 더 넣어줘야한다.
            System.out.print("나이를 입력하세요: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("이름을 입력하세요: ");
            String name = sc.nextLine();

            System.out.println("name: " + name +"\nage: " + age);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
