package example.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
//@ToString 객체 호출시 객체의 주소의 필드 호출
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @ToString @Builder
public class User {
    private int uno;
    private String uid;
    private String uName;
    @Builder.Default //밸더패턴 사용시 해당 필드는 기본값으로 사용

    private List<Board> myBoard = new ArrayList<>();
}
