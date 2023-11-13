package ezenweb.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "productImg") @Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ProductImgEntity extends BaseTime{
    @Id
    private String uuidFileName;
    @Column
    private String realFileName;
    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity;

}
