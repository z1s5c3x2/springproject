package example.객체연관관계;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Comment {
    private int cno;
    private String cContent;
    private Board board;
}
