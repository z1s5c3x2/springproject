package day01.consoleMvc;

import lombok.*;

import java.time.LocalDate;
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
public class LombokDto {
    private int tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}

