package example.day05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 엔티티를 조작하는 인터페이스
@Repository
public interface TodoEntityRepository extends JpaRepository<TodoEntity,Integer> {

}
