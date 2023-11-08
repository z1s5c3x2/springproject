package ezenweb.model.repository;

import ezenweb.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity,Integer> {
    BoardEntity findByBtitle(String btitle);
    //Optional<BoardEntity> findByBtitle(String btitle);
    boolean existsByBtitle(String btitle);
    Page<BoardEntity> findByBtitle(String btitle, Pageable pageable);

    //nativeQuery = true 사용하면 실제 mysql 표현식 사용
    // false 사용지 mysql 표현식이 아닌 jpql 표현식 사용
    @Query(value = " select * from board where " +
            " if(:keyword = '', true, " + // 전체검색 [조건1]
            " if(:key = 'btitle', btitle like %:keyword%, " + // [조건2]
            " if(:key = 'bcontent', bcontent like %:keyword%, true))) order by cdate desc", nativeQuery = true) // [조건3]
    Page<BoardEntity> findBySearch(String key,String keyword, Pageable pageable);

}
