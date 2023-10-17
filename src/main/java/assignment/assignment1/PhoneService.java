package assignment.assignment1;

import example.day05.TodoDto;
import example.day05.TodoEntity;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PhoneService {
    @Autowired
    private PhoneEntityRepository pr;

    public List<PhoneDto> doGet()
    {

        List<PhoneEntity> pe =pr.findAll(Sort.by("pName"));

        List<PhoneDto> res = new ArrayList<>();
        pe.forEach( _tmp ->{
            res.add(PhoneDto.builder()
                            .pno(_tmp.getPno())
                    .pName(_tmp.getPName())
                    .pNumber(_tmp.getPNumber()).build());
        });
        //Collections.sort(res,Comparator.comparing(PhoneDto::getPName));
        return res;
    }

    public boolean doPost(PhoneDto _dto)
    {
        PhoneEntity _tmp = PhoneEntity.builder()
                .pName(_dto.getPName()).pNumber(_dto.getPNumber()).build();

        pr.save(_tmp);

        return false;
    }
    @Transactional
    public boolean doPut(PhoneDto _dto)
    {
        Optional<PhoneEntity> todoEntity = pr.findById(_dto.getPno());

        if(todoEntity.isPresent())
        {
            todoEntity.get().setPNumber(_dto.getPNumber());
            todoEntity.get().setPName(_dto.getPName());

        }

        return false;
    }
    public boolean doDelete(int pno)
    {
        pr.deleteById(pno);


        return false;
    }
}
