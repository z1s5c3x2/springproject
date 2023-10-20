package example.객체연관관계;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Board {
    private int bno;
    private String bTitle;
    private String bContent;
    @ToString.Exclude // 해당 필드는 ToString 제외  주로 참조 객체 권장
    private User writerUser;
}
