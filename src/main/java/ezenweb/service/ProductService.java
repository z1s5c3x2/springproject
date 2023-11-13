package ezenweb.service;


import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.dto.ProductDto;
import ezenweb.model.dto.ProductImgDto;
import ezenweb.model.entity.ProductCategoryEntity;
import ezenweb.model.entity.ProductEntity;
import ezenweb.model.entity.ProductImgEntity;
import ezenweb.model.repository.ProductCategoryEntityRepository;
import ezenweb.model.repository.ProductEntityRepository;
import ezenweb.model.repository.ProductImgEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductCategoryEntityRepository productCategoryEntityRepository;
    @Autowired
    private ProductEntityRepository productEntityRepository;
    @Autowired
    private ProductImgEntityRepository productImgEntityRepository;
    @Autowired
    private FileService fileService;

    @Transactional
    public boolean addCategory(@RequestBody ProductCategoryDto productCategoryDto)
    {
        return productCategoryEntityRepository.save(productCategoryDto.saveToAll()).getPcNo() >= 1;
    }
    @Transactional
    public List<ProductCategoryDto> categoryAllGet()
    {
        return productCategoryEntityRepository.findAll().stream().map(ProductCategoryEntity::allToDto).collect(Collectors.toList());
    }
    @Transactional
    public boolean updateCategory(ProductCategoryDto productCategoryDto)
    {
        ProductCategoryEntity productCategoryEntity = toEntity(productCategoryDto.getPcNo());
        if(productCategoryEntity != null)
        {
            productCategoryEntity.setPcName(productCategoryDto.getPcName());
            return true;
        }
        return false;
    }
    @Transactional
    public boolean deleteCategory(int pcno)
    {
        ProductCategoryEntity productCategoryEntity = toEntity(pcno);
        if(productCategoryEntity!= null){
            productCategoryEntityRepository.delete(productCategoryEntity);
        }
        return false;
    }

    public ProductCategoryEntity toEntity(int pcno){
        return productCategoryEntityRepository.findById(pcno).orElse(null);
    }

    /*제품 등록*/

    public boolean onProductAdd(ProductDto productDto)
    {
        System.out.println("productDto = " + productDto.toString());
        ProductCategoryEntity productCategoryEntity = productCategoryEntityRepository.findById(productDto.getPcNo()).get();
        System.out.println("productCategoryEntity = " + productCategoryEntity);
        ProductEntity productEntity = ProductEntity.builder()
                .pno(productCategoryEntity.getPcNo()+"-"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddmmss")))
                .pName(productDto.getPName())
                .pComment(productDto.getPComment())
                .pPrice(productDto.getPPrice())
                .pStock(productDto.getPStock())
                .productCategoryEntity(productCategoryEntity)
                .productImgEntities(new ArrayList<>()).build();
        /* 제품 이미지 등록 [첨부파일 여러개] */
        System.out.println("productEntity = " + productEntity);
        productDto.getFileList().stream().map( e ->{
            return fileService.fileUpload(e);
        }).collect(Collectors.toList()) // 업로드 된 식별파일명이 반환 , map이니까 리스트로 반환
                .forEach( e -> {
                    productEntity.getProductImgEntities().add(
                            ProductImgEntity.builder()
                                    .uuidFileName(e)
                                    .realFileName(e.split("_")[1])
                                    .productEntity(productEntity).build()
                    );
                });
        productEntityRepository.save(productEntity);
        return true;
    }

    public List<ProductDto> onProductAll()
    {
        List<ProductEntity> productEntityList = productEntityRepository.findAll(Sort.by(Sort.Direction.DESC,"cdate"));
        return productEntityList.stream().map( p->{
            return ProductDto.builder()
                    .pno(p.getPno())
                    .pName(p.getPName())
                    .pState(p.getPState())
                    .pState(p.getPState())
                    .pPrice(p.getPPrice())
                    .pComment(p.getPComment())
                    .categoryDto(ProductCategoryDto.builder().pcNo(p.getProductCategoryEntity().getPcNo())
                            .pcName(p.getProductCategoryEntity().getPcName()).build())
                    .imgList(p.getProductImgEntities().stream().map( (img) ->{
                        return ProductImgDto.builder()
                                .realFileName(img.getRealFileName())
                                .uuidFileName(img.getUuidFileName()).build();
                    }).collect(Collectors.toList())).build();
        }).collect(Collectors.toList());
    }


    public boolean onProductUpdate(ProductDto productDto)
    {
        return false;
    }

    public boolean onProductDelete(String pno)
    {
        return false;
    }

    /*제품 관련*/


}
