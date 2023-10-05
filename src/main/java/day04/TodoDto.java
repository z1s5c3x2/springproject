package day04;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class TodoDto {
    private int tno;
    private String tContent;
    private boolean tState;
}
