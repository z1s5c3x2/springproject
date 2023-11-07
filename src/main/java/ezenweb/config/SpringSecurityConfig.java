package ezenweb.config;

import ezenweb.controller.AuthLoginController;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthLoginController authLoginController;
    //1. method custom
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 0. 인증된 권한
        http.authorizeHttpRequests()
                .antMatchers("/info").hasAnyRole("USER")
                .antMatchers("/board/write").hasAnyRole("USER")
                .antMatchers("/**").permitAll();
        //super.configure(http);
        http.formLogin()                      // 1. 시큐리티 로그인 사용 [ form 전송 ]
                .loginPage("/login")          // 2. 시큐리티 로그인으로 사용할 VIEW페이지의 HTTP 주소 정의
                .loginProcessingUrl("/member/login") // 3.  시큐리티 로그인(인증)처리 요청시 사용할 HTTP 주소 정의
                // 시큐리티 사용하기전에 MemberController 해서 정의한 로그인/로그아웃 함수를 없애기
                // HTTP '/member/login' POST 요청시 ---> MemberService의 loadUserByUsername 로 이동.
                //.defaultSuccessUrl("/")         // 4. 만약에 로그인 성공시 이동할 HTTP 주소
                //.failureUrl("/login") // 5. 만약에 로그인 실패시 이동할 HTTP 주소
                .usernameParameter("memail")        // 6. 로그인시 입력받은 아이디의 변수명 정의
                .passwordParameter("mpassword")
                .successHandler(authLoginController)
                .failureHandler(authLoginController);    // 7. 로그인시 입력받은 비밀번호의 변수명 정의


        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
                                        .invalidateHttpSession(true);
        http.csrf().disable(); // ---- 모든 HTTP POST/PUT 에서 csrf 사용안함.
        //http.csrf().ignoringAntMatchers("/member/post");//특정 http에서만 csrf사용 안함

        //oauth2 커스텀
        http.oauth2Login().loginPage("/login").userInfoEndpoint().userService(memberService) // oauth2 유저 정보를 받을 서비스 선택 (성공만 받음,카카오 로그인 실패시 카카오에서 알려줌)
        ;
    }
    @Autowired
    private MemberService memberService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
        // userdetailsService 구현체 , 사용할 암호화 객체
    }
}
