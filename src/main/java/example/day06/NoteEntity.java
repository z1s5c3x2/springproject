package example.day06;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String title;
    private String writer;
    private String password;
    private LocalDateTime date;

    public NoteDto toDto(){
        return NoteDto.builder()
                .date(this.date)
                .no(this.no)
                .title(this.title)
                .password(this.password)
                .writer(this.writer).build();
    }
}
