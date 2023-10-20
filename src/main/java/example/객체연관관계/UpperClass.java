package example.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UpperClass {
    private String data;
    @Builder.Default
    List<LowerClass> lowerRef = new ArrayList<>();
}
