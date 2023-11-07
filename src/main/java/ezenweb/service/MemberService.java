package ezenweb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.*;

@Service
public class MemberService implements UserDetailsService//  일반회원
        , OAuth2UserService<OAuth2UserRequest, OAuth2User> {//oauth2 회원 서비스{locduser 메소드 구현  oauth2로그인된 회원정보 받는 메소드

    /* configure*/
    //Autowried 사용 불가, 스프링 컨테이너에 등록 안된 빈
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    /*==========================oauth2회원======================*/
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 로그인을성공한 oauth2 계정의 정보 호출
        OAuth2User oAuth2User = new DefaultOAuth2UserService().loadUser(userRequest);
        System.out.println("oAuth2User = " + oAuth2User);

        // 인증 결과 ( 카카오 , 네이버 , 구글 등)
        // 인증한 소셜 서비스 아이디 (각 회사명) 찾기
        String regestratopmId = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("regestratopmId = " + regestratopmId);
        String memail = null;
        String mname = null;
        String mrole = null;
        if(regestratopmId.equals("kakao")) {


            Map<String,Object> stringObjectMap = ((Map<String,Object>)((Map<String,Object>)(oAuth2User.getAttributes().get("kakao_account"))).get("profile"));
            memail = stringObjectMap.get("email").toString();
            mname = stringObjectMap.get("mane").toString();
            Object[] objects = oAuth2User.getAuthorities().toArray();
            System.out.println("memail = " + memail);
            System.out.println("mname = " + mname);
            System.out.println("objects = " + objects);

        }else if(regestratopmId.equals("naver")){
            Map<String,Object> stringObjectMap = (Map<String,Object>)oAuth2User.getAttributes().get("response");
            memail = stringObjectMap.get("email").toString();
            mname = stringObjectMap.get("nickname").toString();
        }else if(regestratopmId.equals("google"))
        {
            memail = oAuth2User.getAttributes().get("email").toString();
            mname = oAuth2User.getAttributes().get("name").toString();
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + regestratopmId));

        if(!memail.isEmpty() && !mname.isEmpty() ) {
            MemberDto mdt = MemberDto.builder()
                    .memail(memail)
                    .mname(mname)
                    .socalAccount(oAuth2User.getAttributes()).build();
            if(!mr.existsByMemail(memail))
            {
                mdt.setMrole("ROLE_USER");
                mdt.setMpassword(new BCryptPasswordEncoder().encode(mname));
                mdt.setMphone("010-1234-4321");
                mr.save(mdt.toEntity());
            }else{
                mdt.setMrole(mr.findByMemail(memail).getMrole());
            }
            System.out.println("mdt.toString() = " + mdt);
            mdt.getGrantedAuthorities().add(new SimpleGrantedAuthority(mdt.getMrole()));
            return mdt;
        }

        return null;
    }



    /* ===========일반회원=======================*/
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String memail ) throws UsernameNotFoundException {
        // * login페이지에서 form을 통해 전송된 아이디 받고 (패스워드 없음)
        System.out.println("loadUserByUsername username = " + memail );
        // - . p.684 인증 절차 순서
        // 1. 사용자의 아이디만으로 사용자 정보[엔티티]를 로딩 [ 불러오기 ] - p.728
        MemberEntity memberEntity =   mr.findByMemail( memail );
        // 1-2. 없는 아이디 이면
        //  throw : 예외처리 던지기 //  new UsernameNotFoundException() : username 없을때 사용하는 예외클래스
        System.out.println("memberEntity = " + memberEntity);
        if( memberEntity == null ){ throw new UsernameNotFoundException("없는 아이디입니다"); }
        // 2. 로딩[불러오기]된 사용자의 정보를 이용해서 패스워드를 검증
        // 2-1 있는 아이디 이면
        /*UserDetails userDetails = User.builder()
                .username( memberEntity.getMemail() )           // 찾은 사용자 정보의 아이디
                .password( memberEntity.getMpassword() )        // 찾은 사용자 정보의 패스워드
                .authorities(memberEntity.getMrole()).build();              // 찾은 사용자 정보의 권한*/


        List<GrantedAuthority> grantedAuthorities  = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(memberEntity.getMrole()));
        MemberDto memberDto = MemberDto.builder()
                .memail(memberEntity.getMemail())
                .mpassword(memberEntity.getMpassword())
                .mname(memberEntity.getMname())
                .grantedAuthorities(grantedAuthorities).build();

        return memberDto;
    }



    /**/


    @Autowired
    MemberEntityRepository mr;

    @Autowired
    private HttpServletRequest request;
    @Transactional
    public MemberDto getMember() {
        //시큐리티 사용하기 전에는 서블릿 세션을 이용한 로그인 상태 저장
        // 시큐리티 사용시 일단 서블릿 세션이 아니고 시큐리티 저장소 이용
        System.out.println("시큐리티에 저장된 세션 정보 저장소 : " + SecurityContextHolder.getContext());
        System.out.println("시큐리티에 저장된 세션 정보 저장소에 저장된 인증 : " + SecurityContextHolder.getContext().getAuthentication());
        System.out.println("시큐리티에 저장된 세션 정보 저장소에 저장된 인증 호출 : " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (o.equals("anonymousUser"))
        {
            return null;
        }
        UserDetails userDetails = (UserDetails)o;
        MemberEntity memberEntity = mr.findByMemail(userDetails.getUsername());

        return MemberDto.builder().mno(memberEntity.getMno()).memail(userDetails.getUsername()).build();
    }
    @Transactional
    public boolean doPost(MemberDto mdt)
    {
        //암호화
        mdt.setMpassword(passwordEncoder.encode(mdt.getMpassword()));
        //
        System.out.println("mdt = " + mdt);

        MemberEntity result = mr.save(mdt.toEntity());
        return result.getMno() >=1;
    }
    //2 r
    @Transactional
    public MemberDto doGet(int mno)
    {
        System.out.println("mno = " + mno);
        Optional<MemberEntity> res = mr.findById(mno);
        MemberDto result = new MemberDto();
        if(res.isPresent())
        {
            result = res.get().toDto();
        }else{
            return null;
        }
        return result;
    }
    //3 u
    @Transactional
    public boolean doPut(MemberDto mdt)
    {
        System.out.println("mdt = " + mdt);
        Optional<MemberEntity> memberEntityOptional =  mr.findById(mdt.getMno());
        if(memberEntityOptional.isPresent()) {
            MemberEntity _m = memberEntityOptional.get();
            _m.setMphone(mdt.getMphone());
            _m.setMpassword(mdt.getMpassword());
            _m.setMname(mdt.getMname());
            //doLogin(mdt);
            return true;
        }else{
        return false;}
    }
    //4 d
    @Transactional
    public boolean doDelete(int mno)
    {
        System.out.println("mno = " + mno);
        if(mr.findById(mno).isPresent())
        {
            mr.deleteById(mno);
            return true;
        }else{
            return false;
        }
    }
    //아이디 찾기
    @Transactional
    public String doFindMemberId(MemberDto _dto)
    {

        System.out.println("MemberService.doFindMemberId");
        System.out.println("_dto = " + _dto);
        Optional<MemberEntity> _m = mr.findByMnameAndMphone(_dto.getMname(), _dto.getMphone());
        if(_m.isPresent())
        {
            return _m.get().getMemail();
        }
        return null;
    }
    @Transactional
    public String doFindMemberPwd(MemberDto _dto)
    {
        System.out.println("_m.toString() = " +_dto.toString());
        Optional<MemberEntity> _m = mr.findByMemailAndMphone(_dto.getMemail(),_dto.getMphone());
        System.out.println("_m = " + _m.toString());
        if(_m.isPresent())
        {

            return _m.get().toDto().getMpassword();
        }
        return null;
    }
    /*
    @Transactional
    public boolean doLogin(MemberDto _dto)
    {
        if(null == request.getSession().getAttribute("loginDto"))
        {
            Optional<MemberEntity> optionalMemberEntity = mr.findByMemailAndMpassword(_dto.getMemail(),_dto.getMpassword());
            if(optionalMemberEntity.isPresent())
            {
                request.getSession().setAttribute("loginDto", optionalMemberEntity.get().toDto());
                return true;
            }
        }
        return false;
    }
    @Transactional
    public boolean doLogOut()
    {
        System.out.println(request.getSession().getAttribute("loginDto"));
        if(null != request.getSession().getAttribute("loginDto"))
        {
            request.getSession().setAttribute("loginDto",null);
            return true;
        }
        System.out.println(request.getSession().getAttribute("loginDto"));
        return false;
    }
    public MemberDto getMember(){
        // 1. 세션 호출
        Object session = request.getSession().getAttribute("loginDto");
        // 2. 세션 검증
        if( session != null ){
            return (MemberDto) session;
        }
        return null;
    }*/

    public boolean findByMemail(String memail)
    {
        return !mr.existsByMemail(memail);
    }




}

