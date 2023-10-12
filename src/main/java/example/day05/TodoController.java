package example.day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/index")
    public Resource getIndex()
    {
        return new ClassPathResource("templates/todo.html");
    }

    @GetMapping("")
    public List<TodoDto> doGet()
    {
        List<TodoDto> res = todoService.doGet();
        return res;

    }
    @PostMapping("")
    public boolean doPost(@RequestBody TodoDto _dto)
    {
        boolean result = todoService.doPost(_dto);
        return result;
    }
    @PutMapping("")
    public boolean doPut(@RequestBody TodoDto _dto)
    {
        boolean result = todoService.doPut(_dto);
        return result;
    }
    @DeleteMapping("")
    public boolean doDelete(@RequestParam int tno)
    {
        boolean result = todoService.doDelete(tno);
        return false;
    }


}
