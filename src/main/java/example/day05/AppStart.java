package example.day05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

/*
    그레이들에 빌드할 의존성 추가
        gradle groovy
            java
                    spring boot 2.7.16
* -dependencies
*   spring web 스프링 라이브러리 지원
    lombok
    mysql driver


        build.gradle에 dependencies 추가
   프로젝트 폴더 구성
        프로젝트 명
            .gradle : build.gradle
            .idea : 인텔리제이 셋팅 파일
            .build : jvm 빌드시 생성한 바이트파일
            ***src 개발자가 코드를 작성하는 공간
               main
                    java : 백엔드
                     resources : 프론트앤드
                     
          ***build.gradle : 라이브러리 자동 빌드 해주는 작성 코드 파일

 스프링 부트실행
    준비물
        main함수 1개 필요
           1. 클래스 1개 생성 [ 스프링 실행하는 클래스 ,모든 소스파일의 최상위 위치]
           2. 클래스 상단
                @SpringBootApplication주입
           3. main선언
                   SpringApplication.run(현재클래스명.class);

   -어노테이션
   1.스프링
    @SpringBootApplication    스프링부트 실행 관련 제공
    @servletComponentScan     서블릿을 찾아서 컨테이너에 빈 등록
    @AutoWried                  컨테이너에서 빈 찾아서 객체 주입
   2.mvc
    @Controller                해당 클래스를 controller 사용 주입 [컨테이너에 빈 등록]
    @RestController            해당 클래스를 controller 사용 주입  [컨테이너에 빈 등록] + @ResponseBody
    @ResponsBody              해당 mapping 함수들의 response 반환타입을 자동으로 설정
    @***Mapping             HTTP요청 **** 함수 매핑
    @Service             해당 클래스를 service 사용 주입 [ 컨테이너에 빈 등록]
    @Component          해당 클래스를 컨테이너에 빈 등록
        @RequestParm    쿼리스트링 형식의 요청 매개변수 매핑            Url?args=var?args=var
        @RequestBody    Http body 형식의 요청 매개변수를 객체로 매핑
        @ModelAttribute 쿼리스트링 형식의 요청 매개변수를 객체로 매핑
        @PathVariable   경로상의 매개변수 형식의 요청 매개변수 매핑     URL/var/var
   3.lombok
   @NoArgsConstructor
   @AllArgsConstructor
   @Getter
   @Setter
   @ToString
   @Builder
   
   패러다임(=방식/체개/규정 틀)
   orm(object relational mapping) : 객체 관계 매핑
   - 객체 지향 프로그래밍 객체들간의 상호작용을 통한 프로그래밍
   - 관계형 데이터베이스 :열/행의 테이블/관계로 데이터를 저장하는 방식
   관계형 데이터베이스를 객체지향으로 사용
   JPA:java persistence api: orm 패러다임으로 만들어진 라이브러리
   spring.jpa.hibernate.ddl-auto  DDL 자동 실행
   create 매핑된 엔티티가 실제 db에 없으면 새로운 테이블 생성
   update 
        매핑된 엔티티가 실제 db에 없으면 새로운 테이블 생성
        매핑된 엔티티가 실제 db에 있으면 업데이트

      엔티티 선언
        @Entity
        @Id
    엔티티 조작 [인터페이스]
    JPARepository
        1.인터페이스 생성
        2.@Repository 주입
        3.public class TodoEntityRepository extends JpaRepository<조작할엔티티클래스명,해당엔티티pk필드자료형>
            -조작할때 PK필드로 식별 하므로 각 엔티티별 PK 필드는 필수
     엔티티 인터페이스 사용처[서비스]
       1.  CRUD
        1.insert
            인터페이스명.save(저장할엔티디)
             반환타입: 생성된 엔티티 반환
         2. select
            1. 인터페이스명.FindAll()
                list<엔티티>
            2. 인터페이스명.FindById()
                optional<TodoEntity>
                Optional 클래스 : null 관련 메소드 제공 [ nullpointerException 안전성 보장]
                  -객체가 null인데 그 객체에 접근시 예외 발생 ( . = 접근 연산자)
         3.Put
            1.엔티티객체명.set필드명();
                @Transactional를 주입해야 commit(db 최신화)이 된다
         4.Delete
            1.인터페이스명.delete()
                void
            2.인터페이스명.deleteById
                void

* */