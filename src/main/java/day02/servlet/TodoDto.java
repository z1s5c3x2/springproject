package day02.servlet;

import lombok.*;

import java.time.LocalDate;
@Getter@Setter@Builder@AllArgsConstructor@NoArgsConstructor@ToString
public class TodoDto {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
