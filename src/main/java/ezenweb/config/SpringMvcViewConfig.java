package ezenweb.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class SpringMvcViewConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController( "/{spring:\\w+}").setViewName("forward:/");
        registry.addViewController( "/**/{spring:\\w+}").setViewName("forward:/");
        registry.addViewController( "/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}").setViewName("forward:/");
    }
}

/*
* 스프링MVC 아키텍쳐에서는 controller가 view 반환하는 작업 실행
* 문제점 : 리액트와 스프링 통합시 리액트 (link,get) , 스프링(get)
*  스프링 안에 리액트가 포함되므로 get요청시 스프링 매핑 우선(디스패처 서블릿)
*
* 해결 : get 요청시 view를 찾을때 controller가 resouces가서 찾으라고 설정
* 1. 스프링 설정 클래스 생성
* 2. extends WebMvcConfigurerAdapter : mvc 아키텍처 설정 커스텀 해주는 클래스
* 3. 우클릭 , 생성 , 오버라이딩
* 4. addViewControllers 메소드 오버라이딩/재정의 하기
*
*  스프링리액트 통합 개발 환경
*   springboot : 2.7.17 / node : v20.8.1
*
* */
