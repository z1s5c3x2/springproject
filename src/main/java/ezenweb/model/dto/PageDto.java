package ezenweb.model.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @ToString @Builder @AllArgsConstructor @NoArgsConstructor
public class PageDto {
    List<BoardDto>boardDtos;
    int totalPages;
    Long totalElement;
}
