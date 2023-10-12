package example.day05;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class TodoDto {
    private int tno;
    private String tContent;
    private boolean tState;
}
