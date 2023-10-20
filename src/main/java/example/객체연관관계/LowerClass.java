package example.객체연관관계;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class LowerClass {
    private String data;
    @ToString.Exclude
    private UpperClass upperObj;
}
