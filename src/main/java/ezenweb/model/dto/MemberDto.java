package ezenweb.model.dto;

import ezenweb.model.entity.BaseTime;
import ezenweb.model.entity.MemberEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class MemberDto implements UserDetails, OAuth2User {
    /*userDetials*/
    @Builder.Default
    private List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    @Override // 게정 권한 목록
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return mpassword;
    }

    @Override
    public String getUsername() {
        return memail;
    }

    @Override //계정 만료
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override // 계정 잠금
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override   // 계정 증명 여부
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /*Oaut*/
    private Map<String,Object> socalAccount = new HashMap<>();
    @Override
    public Map<String, Object> getAttributes() {
        return socalAccount;
    }

    @Override
    public String getName() {
        return this.memail;
    }

    /*member*/
    private int mno;            // 1. 회원번호
    private String memail;      // 2. 이메일 [ 회원아이디 객체
    private String mpassword;   // 3. 비밀번호
    private String mname;       // 4. 이름
    private String mphone;      // 5. 연락처-
    private String mrole;       // 6. 회원 등급
    private LocalDateTime cdate;
    private LocalDateTime udate;
    public MemberEntity toEntity() {

        return MemberEntity.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mpassword(this.mpassword)
                .mrole(this.mrole)
                .mphone(this.mphone)
                .mname(this.mname)
                .build();
    }
}
