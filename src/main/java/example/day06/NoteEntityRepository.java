package example.day06;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteEntityRepository extends JpaRepository<NoteEntity,Integer> {

}
