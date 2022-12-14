package kakao.hb9397.controlstatement;

import java.util.Scanner;

public class PassIf {
    public static void main(String[] args){
//        try(Scanner sc = new Scanner(System.in)){
//            System.out.print("점수 입력");
//            int score = sc.nextInt();
//
//            if(score >= 60){
//                System.out.println("합격");
//            }else{
//                System.out.println("불합격");
//            }
//        }catch (Exception e){
//            System.out.println(e.getLocalizedMessage());
//        }

        try(Scanner sc = new Scanner(System.in)){
            System.out.print("점수 입력 : ");
            int score = sc.nextInt();

            if(score >= 90){
                System.out.print("A");
                if(score >= 95){System.out.print("+");}
            }else if(score >= 80){
                System.out.print("B");
                if(score >= 85){System.out.print("+");}
            }else if(score >= 70){
                System.out.print("C");
                if(score >= 75){System.out.print("+");}
            }else if(score >= 60) {
                System.out.print("D");
                if(score >= 65){System.out.print("+");}
            }else if(score < 60){
                System.out.println("F");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

//        try(Scanner sc = new Scanner(System.in)){
//            System.out.print("아이디를 입력 하세요: ");
//            String id = sc.nextLine();
//            System.out.print("비밀번호를 입력 하세요: ");
//            String password = sc.nextLine();
//
//            // 문자열은 생성 방법에 따라 다른 인스턴스가 될 수있기 때문에 값이 동일한지 비교할 때는 ==연산자가 아닌
//            // equals 메서드를 이용해서 동일성 여부를 비교해야 한다.
//            if(id.equals("root") && password.equals("1234")){
//                System.out.println("로그인 성공");
//            }else{
//                System.out.println("로그인 실패");
//            }
//
//        }catch (Exception e){
//            System.out.println(e.getLocalizedMessage());
//        }

    }
}
