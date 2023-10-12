package example.day01.webMvc;


import lombok.*;

import java.time.LocalDate;
@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor@ToString
public class WebDto {
    private int tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;


}
