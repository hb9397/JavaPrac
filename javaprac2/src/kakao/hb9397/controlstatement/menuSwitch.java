package kakao.hb9397.controlstatement;

import java.util.Scanner;

public class menuSwitch {
    public static void main(String[] args){

        try (Scanner sc = new Scanner(System.in)){
            System.out.print("메뉴 입력(1~3): ");
            int menu = sc.nextInt();
            // case 의 값은 리터럴이나 상수밖에 쓰지 못한다, 일반 변수는 사용할 수 없다.!!
            // Ex> int CHINA = 1, ---> case CHINA : ~ 는 불가능하다.
            // Ex> final CHINA = 1 ---> case CHINA : ~ 와 같이 case의 값을 상수 변수로 만들면 사용할 수 있다.
            switch (menu){
                case 1:
                    System.out.println("중식");
                    break;
                case 2:
                    System.out.println("한식");
                    break;
                case 3:
                    System.out.println("분식");
                    break;
                default:
                    System.out.println("굶어 걍걍");
                   break;
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
