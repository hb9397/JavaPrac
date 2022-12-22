package kakao.hb9397.java.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarMain {
    public static void main(String[] args){
        // Calendar로 원하는 날짜를 생성하고 Date로 변환
        Calendar calendar = new GregorianCalendar(1986, 3, 5);
        Date date  = new Date(calendar.getTimeInMillis());
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 EEEE a hh:mm:ss");
        System.out.println(format.format(date));
    }
}
