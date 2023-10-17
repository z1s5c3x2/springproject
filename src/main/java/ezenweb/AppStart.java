package ezenweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
/*
*  @CreateDate 엔티티 생성시 시간 자동 저장/주입
*  @LastModifiedDate 엔티티 변경시 자동 생성/주입
*  @Mapping jpa 엔티티 클래스들의 공통 필드 상속할때 사용하는 어노테이션
*  @EntityListeners(AuditingEntityListener.class) 해당 클래스에서 엔티티 감지 가능
*  @EntityListeners : 특정 이벤트가 발생 할때마다 특정 로직 실행
*     @AuditingEntity 감지 이벤트 실행
*       @LastModifiedDate,@CreateDate
*       @EnableJpaAuditing spring data Jap auditing을 이용한 엔티티 감지
*
*   Web Layer / presentation layer
*       controller view[jsp,templates,html]
*
*          DTo
*   Service Layer / business layer
*       logic
*
*               entity
*   Repository Layer / persistence layer
*       imtertaces[dao,repository]
*
* 1. 클라이언트가 http 프로토콜로 요청
* 2. dispatcher servlet이 handler mapping에게 요청 (인터페이스)
*       클라이언트가 요청한 url에 대한 컨트롤러 찾기, controller의 이름을 반환
* 3.handler adapter에게 controller의 이름으로 요청
* 4 handler adapter가 컨트롤러에게 요청
* 5. 트랜잭션 : 다수의 sql의 최소 단위
*       완료 : commit
*       취소 : rollback ( 부분성공 X )
* 6 controller <--> service Dto
*   repository < --> service Entity
*
*   View Resolver ( Resources )
*     View 리턴 ( 문자 형식,파일X) ->
*     Model 8,9작업 없이 10번작업
*   10 : model의 타입 변환
*
* spring mvc
*  클라이언트가 서버에 요청을 할 때 요청 프로토콜이 HTTP라면 dispatcher sevlet가 모두 받는다
*    -dispatcher servlet는 HTTP 프로토콜로 들어오는 모든 요청을 가장 먼저 받아 적합한 컨트롤러에게 위임해주는 프론트컨트롤러라고 정의 할 수 있다
*  그러면 dispatcher servlet이 handler mapping에게 요청 url과 매칭되는 컨트롤러를 수행 할 수 있는 handler를 찾아 핸들러의 이름을 반환한다
*  반환된 이름으로 handler adapter가 해당 이름에 적합한 핸들러를 실행하여 controller가 실행된다
*  호출된 controller는 실제 데이터를 가공하는 business logic을 수행하는 service를 호출하여
*  요청받은 service는 business logic을 수행하는데 이 때 db를 조회하여 데이터를 가공한다면
*  respository에게 요청을 하는데, 여기서 사용하는 객체는 Entity의존성이 주입된 객체를 사용한다.
*  이렇게 가공된 데이터는 model&view로 controller는 handler adapter에게 반환,handler adapter는 dispatcher servlet에 반환한다
* dispatcher servlet에게 반환된 데이터가 view라면
* view resolver에게 요청하여 view의 이름을 논리 이름에서 물리 이름으로 변환하고 이름에 적합한 랜더링 역할을 담당하는 view객체를 반환한다
*  이제 view에게 요청을 하여 데이터를 어떻게 보여줄지 설정하는데
*  json 형태(Json View)로 전달할 수도 있고, 자바 프론트엔드 언어인 JSP 페이지의 형태로 전달할 수도 있다.
*
*
*
*
* */