package ezenweb.model.repository;

import ezenweb.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {

    // 1. 제품별 재고 수
    @Query(value = "select p_name,p_stock from product",nativeQuery = true)
    List<Map<Object, Object>> findByBarChart();

    // 2. 카테고리별 제품 수
    @Query(value = "select pc_name,count(*) p_cnt from product p inner join productcategory pc on p.pcno = pc.pc_no group by pc.pc_name;",nativeQuery = true)
    List<Map<Object, Object>> findByPieChart();
}