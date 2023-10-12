package example.day02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 개발자가 스프링 외 추가등록된 코드를 스프링이 알고 있도록 등록
@ServletComponentScan // SPRING MVC 외 추가된 서블릿을 검색해서 컴포넌트 등록 /
@SpringBootApplication
public class WebStart {
    public static void main(String[] args) {
        SpringApplication.run( WebStart.class );
    }
}

/*
    스프링부트의 시작
        1. 해당 클래스의 @SpringBootApplication
            // Spring MVC , RESTFUL , *** 내장톰캣 등등
            // C[ 컨트롤러 = 서블릿 ]
        2. main 선언 [ 스레드 1개 필요 ]
        3. main 함수 정의
            SpringApplication.run() : 스프링 시작함수
            SpringApplication.run( 현재클래스.class ) : 현재 클래스를 스프링이 시작.

 */