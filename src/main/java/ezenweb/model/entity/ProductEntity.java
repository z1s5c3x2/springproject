package ezenweb.model.entity;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "product")
@Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ProductEntity extends BaseTime{
    @Id
    private String pno;
    @Column
    private String pName;
    @Column(columnDefinition = "LONGTEXT")
    private String pComment;
    @Column
    private int pPrice;
    @Column @ColumnDefault("0")  // 상태 0 판매중     1 판매중지     2 재고없음 3 폐기
    private byte pState;
    @Column @ColumnDefault("0")
    private int pStock;

    @ManyToOne
    @JoinColumn(name = "pcno")
    private ProductCategoryEntity productCategoryEntity;
    @OneToMany(mappedBy = "productEntity",fetch = FetchType.LAZY, cascade = CascadeType.ALL) @ToString.Exclude
    private List<ProductImgEntity> productImgEntities = new ArrayList<>();
}


/*
CascadeType.ALL   remove persist 적용
CascadeType.REMOVE 부모 삭제시 자식 삭제
CascadeType.PERSIST

fetch 양방향일때 참조를 불러오는 로딩 옵션
FetchType.LAZY 참조 사용시 로딩
FetchType.EAGER : 참조값 즉시 로딩 select시 객체 불러옴
* */