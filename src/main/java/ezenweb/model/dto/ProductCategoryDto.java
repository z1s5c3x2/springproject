package ezenweb.model.dto;

import ezenweb.model.entity.ProductCategoryEntity;
import ezenweb.model.entity.ProductEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategoryDto {
    private int pcNo;
    private String pcName;

    public ProductCategoryEntity saveToAll()
    {
        return ProductCategoryEntity.builder()
                .pcNo(this.pcNo)
                .pcName(this.pcName).build();
    }
}
