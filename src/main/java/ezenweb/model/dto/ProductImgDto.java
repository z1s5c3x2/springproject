package ezenweb.model.dto;

import ezenweb.model.entity.ProductEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductImgDto {
    private String uuidFileName;
    private String realFileName;
    private ProductEntity productEntity;
}
