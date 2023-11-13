package ezenweb.model.entity;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.dto.ProductDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "productcategory")
@Builder @AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategoryEntity extends BaseTime{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pcNo;
    @Column
    private String pcName;

    @OneToMany(mappedBy = "productCategoryEntity",fetch = FetchType.LAZY, cascade = CascadeType.ALL) @ToString.Exclude @Builder.Default
    private List<ProductEntity> productEntities = new ArrayList<>();


    public ProductCategoryDto allToDto()
    {
        return ProductCategoryDto.builder()
                .pcNo(this.pcNo)
                .pcName(this.pcName).build();
    }
}
