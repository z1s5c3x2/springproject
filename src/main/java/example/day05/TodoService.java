package example.day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoEntityRepository tr;

    public boolean doPost(TodoDto _dto){
        TodoEntity tn = TodoEntity.builder().tcontent(_dto.getTContent()).tstate(_dto.isTState()).build();
        tr.save(tn);
        return false;
    }
    public List<TodoDto> doGet()
    {
        List<TodoEntity> te =  tr.findAll();
        List<TodoDto> res = new ArrayList<>();
        te.forEach( (tn) -> {
            TodoDto _tmp = TodoDto.builder().tContent(tn.getTcontent()).tno(tn.getTno()).tState(tn.isTstate()).build();
            res.add(_tmp);
        });
        return res;
    }

    @Transactional
    public boolean doPut(TodoDto _dto)
    {
        Optional<TodoEntity> todoEntity = tr.findById(_dto.getTno());

        if(todoEntity.isPresent())
        {
            todoEntity.get().setTstate(!_dto.isTState());

        }

        return false;
    }
    public boolean doDelete(int tno)
    {
        tr.deleteById(tno);


        return false;
    }
}
