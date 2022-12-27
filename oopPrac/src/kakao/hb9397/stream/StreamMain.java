package kakao.hb9397.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String [] main){

        // Stdent 클래스의 인스턴스를 요소로 갖는 ArrayList 의 인스턴스 생성
        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "리븐", "여자", "탑" ,88));
        list.add(new Student(2, "바루스", "남자", "바텀" ,90));
        list.add(new Student(3, "룰루", "여자", "바텀" ,99));
        list.add(new Student(4, "이렐리아", "여자", "탑" ,87));
        list.add(new Student(5, "티모", "남자", "트롤" ,80));


        // Student 인스턴스들의 score 합계\
        // Student를 Student.get Score 메서드 결과를 이용해서 정수로 변환한다.
        int sum = list.stream().mapToInt(Student::getScore).sum();
        System.out.println("점수의 합계 : " + sum);

        // 평균 구하기
        // Optional 이 붙는 자료형은 null 여부를 확인하고 사용하는 것을 권장한다, average는 반환형이 OptionalDouble
        OptionalDouble avg = list.stream().mapToInt(Student::getScore).average();
        if(avg.isPresent() == true){
            System.out.println("평균 :" + avg.getAsDouble());
        } else {
            System.out.println("평균을 구할 수 없음");
        }

        // reduce - 집계
        // 매개변수가 2개이고 반환값이 있는 메서드를 제공한다.
        // 처음 2개의 데이터를 가지고 메서드를 호출해서 결과를 만들고 그 다음부터는 결과 다음 데이터를 가지고 메서드를 호출한다.
        System.out.println("\nreduce를 이용한 합계구하기");
        sum = list.stream().mapToInt(Student::getScore).reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("reduce sum : " + sum);

        // collect - 추출
        // 남자만 추출해서 List로 변환
        List<Student> manList = list.stream().filter(student -> student.getGender().equals("남자")).collect(Collectors.toList());
        System.out.println("\ncollect로 gender가 남자인 것만 뽑아서 manList로 변환");
        System.out.println(manList);

        // gender 별로 그룹화 해서 score의 평균을 구한다.
        System.out.println("\ncollect(Collectors.grouping() 을 이용해 gender 별로 그룹화하고 그룹별 평균 구하기");
        Map<String, Double> genderMap = list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getScore)));

        System.out.println(genderMap);
        // 그룹별로 값 접근하기
        System.out.println(genderMap.get("남자"));
        System.out.println(genderMap.get("여자"));
   }
}
