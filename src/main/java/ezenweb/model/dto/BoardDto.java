package ezenweb.model.dto;


import ezenweb.model.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @Builder @ToString @AllArgsConstructor @NoArgsConstructor
public class BoardDto {
    private int bno;
    private String btitle;
    private String bcontent;
    private int bview;
    private String bfile;
    private int mno;
    private LocalDateTime cdate;
    private LocalDateTime udate;

    public BoardEntity saveToEntity()
    {
        return BoardEntity.builder()
                .btitle(this.btitle)
                .bfile(this.bfile)
                .bview(this.bview)
                .bcontent(this.bcontent)
                .mno(this.mno)
                .build();
    }
}
