package ezenweb.model.entity;

import ezenweb.model.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "board")
@DynamicInsert
public class BoardEntity extends BaseTime{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int bno;
    @Column(name = "btitle",length = 200,nullable = false)
    private String btitle;
    @Column(columnDefinition = "longtext")
    private String bcontent;
    @Column()
    @ColumnDefault("0")
    private int bview;
    @Column(columnDefinition = "longtext")
    private String bfile;

    @ToString.Exclude @JoinColumn(name = "mno_fk")
    @ManyToOne
    private MemberEntity memberEntity;


    public BoardDto allToDto()
    {
        return BoardDto.builder()
                .bno(this.bno)
                .bview(this.bview)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bfile(this.bfile)
                .mno(this.memberEntity.getMno())
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .build();
    }
}
/*
* create table board (
       bno integer not null auto_increment,
        cdate datetime(6),
        udate datetime(6),
        bcontent longtext,
        bfile longtext,
        btitle varchar(200) not null,
        bview integer default 0,
        mno integer,
        primary key (bno)

*
* */