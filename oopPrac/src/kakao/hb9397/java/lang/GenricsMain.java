    package kakao.hb9397.java.lang;

    public class GenricsMain {
        public static void main(String[] args){
            // Generic 클래스 사용, 자료형 지정해 주기
            // Generics가 적용된 클래스의 인스턴스를 만들 때는 실제 자료형을 지정해야 경고가 발생하지 않는다.
            Generic <String> obj1 = new Generic<>("해글러", "리븐", "드레이븐", "다리우스");

            // Generic 클래스 배열에 요소를 출력하는 함수 호출
            obj1.disp();

            // 아래와 같이 Java의 기본형들은  Genrics에 적용할 수 없다.
            // Generic<int> obj2 = new Generic<int>();

            // 기본형을 사용하고자 하면 Wrapper Class 들을 이용한다.
            Generic<Integer> obj2 = new Generic<>(100, 200, 300, 333);
            obj2.disp();

        }
    }
