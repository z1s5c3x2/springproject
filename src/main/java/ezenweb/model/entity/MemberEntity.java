package ezenweb.model.entity;

import ezenweb.model.dto.MemberDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 해당 클래스를 db테이블과 매핑 [ 엔티티 클래스 <----> db 테이블 ( 엔티티 객체  1개 <----> db테이블 내 레코드)]
@Table(name = "member") // DB테이블명 정의 [ 생략시 해당 클래스명이 db테이블명으로 자동 생성 ]
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
@DynamicInsert
public class MemberEntity extends BaseTime{
    @Id // 해당 필드를 pk로 선정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int mno;            // 1. 회원번호
    @Column(name = "memail", length = 50, nullable = false, unique = true) // 해당 필드 선정 [ 속성 ] name = "필드명"
    private String memail;      // 2. 이메일 [ 회원아이디 객체 ]
    @Column(length = 100, nullable = false) // 해당 필드 선정
    private String mpassword;   // 3. 비밀번호
    @Column(length = 20, nullable = false) // 해당 필드 선정
    private String mname;       // 4. 이름
    @Column(length = 14, nullable = false, unique = true) // 해당 필드 선정
    private String mphone;      // 5. 연락처
    @Column // 해당 필드 선정
    @ColumnDefault("'ROLE_USER'") // ColumnDefault("초기값")
    private String mrole;       // 6. 회원 등급

    //외래키
    @Builder.Default
    @OneToMany(mappedBy = "memberEntity")
    private List<BoardEntity> boardEntityList = new ArrayList<>();
    public MemberDto toDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mpassword(this.mpassword)
                .mrole(this.mrole)
                .mphone(this.mphone)
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .mname(this.mname)
                .build();
    }
}