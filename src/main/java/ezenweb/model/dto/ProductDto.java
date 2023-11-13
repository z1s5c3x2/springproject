package ezenweb.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
    private String pno;
    private String pName;
    private String pComment;
    private int pPrice;
    private byte pState;
    private int pStock;
    private List<MultipartFile> fileList; // 첨부파일여러개일때 리스트로 받기
    private int pcNo;
    
    private ProductCategoryDto categoryDto;
    private List<ProductImgDto> imgList;
}
