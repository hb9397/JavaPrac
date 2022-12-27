package test.junitExam;

import org.junit.Assert;
import org.junit.Test;

public class Test2 {
    @Test
    public void testmethod(){
        System.out.println(new Source().add(100, 200));
    }

    @Test
    public void testmethod1(){
        Source source = new Source();

        // 메서드의 수행 결과값 찾아오기
        int result = source.add(100, 200);

        // 기대값 결과값 비교 -> 일치하면 정상 수행 일치하지 않으면 예외 발생
        Assert.assertEquals(result, 500);
    }
}
