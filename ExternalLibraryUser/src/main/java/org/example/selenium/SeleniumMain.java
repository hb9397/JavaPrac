package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMain {
    public static void main(String[] args) {
        // 다운받은 크롬의 드라이버 위치를 설정한다.
        System.setProperty("webdriver.crhome.driver", "C:\\chromedriver.exe");

        // 드라이버 로드
        WebDriver driver = new ChromeDriver();

        // 사이트 접속
        // 브라우저를 출력하지 않고 가져오고 싶다면
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");
        //
        // 로 설정하면 출력하지 않는다.
        driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");

        // JS 실행
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // id, pw 입력하기
        js.executeScript("document.getElementsByName('id')[0].value=\'" + "adam" + "\'");
        js.executeScript("document.getElementsByName('pw')[0].value=\'" + "adam" + "\'");

        // 로그인 버튼 클릭
        // xpath 는 개발자도구의 Elements 탭에서 우클릭 [copy]-[xpath] 로 가져오면 된다.
        driver.findElement(By.xpath("//*[@id=\"log.login\"]")).click();
        driver.get("https://cafe.naver.com/joongoonara");

        // 소스코드 가져오기
        System.out.println(driver.getPageSource());
    }
}
