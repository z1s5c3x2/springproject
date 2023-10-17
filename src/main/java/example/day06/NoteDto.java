package example.day06;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
public class NoteDto {
    private int no;
    private String title;
    private String writer;
    private String password;
    private LocalDateTime date;

    public NoteEntity toEntity()
    {
        return NoteEntity.builder()
                .date(this.date)
                .no(this.no)
                .title(this.title)
                .password(this.password)
                .writer(this.writer).build();
    }
}
