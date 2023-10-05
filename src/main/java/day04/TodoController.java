package day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping("")
    public boolean doPost(@RequestBody TodoDto dto)
    {
        System.out.println("TodoController.doPost");
        System.out.println("dto = " + dto);

        return todoService.doPost(dto);
    }

    @GetMapping("")
    public List<TodoDto> doGet()
    {
        System.out.println("TodoController.doGet");
        return todoService.doGet();
    }

    @PutMapping("")
    public boolean doPut(@RequestBody TodoDto dto)
    {
        System.out.println("TodoController.doPut");
        System.out.println("dot = " + dto);

        return todoService.doPut(dto);
    }

    @DeleteMapping("")
    public boolean doDelete(@RequestParam int tno)
    {
        System.out.println("TodoController.doDelete");
        System.out.println("tno = " + tno);
        return todoService.doDelete(tno);
    }

    @GetMapping("/index")
    public Resource getIndex()
    {
        return new ClassPathResource("templates/todo.html");
    }
}
