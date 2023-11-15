package ezenweb.controller;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.dto.ProductDto;
import ezenweb.model.entity.ProductCategoryEntity;
import ezenweb.model.repository.ProductCategoryEntityRepository;
import ezenweb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/category")
    public boolean addCategory(@RequestBody ProductCategoryDto productCategoryDto)
    {
        return productService.addCategory(productCategoryDto);
    }

    @GetMapping("/category")
    public List<ProductCategoryDto> printCategory()
    {
        return productService.categoryAllGet();
    }

    @PutMapping("/category")
    public boolean updateCategory(@RequestBody ProductCategoryDto productCategoryDto)
    {
        return productService.updateCategory(productCategoryDto);
    }
    @DeleteMapping("/category")
    public boolean deleteCategory(@RequestParam int pcNo)
    {
        return productService.deleteCategory(pcNo);
    }

    /*제품 등록*/
    @PostMapping("")
    public boolean onProductAdd(ProductDto productDto)
    {
        System.out.println("productDto = " + productDto.toString());
        return productService.onProductAdd(productDto);
    }
    @GetMapping("")
    public List<ProductDto> onProductAll()
    {

        return productService.onProductAll();
    }

    @PutMapping("")
    public boolean onProductUpdate(@RequestBody ProductDto productDto)
    {
        return productService.onProductUpdate(productDto);
    }
    @DeleteMapping("")
    public boolean onProductDelete(@RequestParam String pno)
    {
        return productService.onProductDelete(pno);
    }
    /*제품 등록*/

    @GetMapping("/barchart")
    public List<Map<Object,Object>> getBarchart()
    {

        return productService.getBarchart();
    }
    @GetMapping("/piechart")
    public List<Map<Object,Object>> getPiechart()
    {

        return productService.getPieChart();
    }
}
