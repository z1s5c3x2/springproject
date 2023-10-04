package day02.servlet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TodoService {

    public void register(TodoDto tdt) {
        System.out.println("TodoService.register");
    }

    public List<TodoDto> getList() {
        List<TodoDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(TodoDto.builder()
                    .tno((long) i)
                    .title("todo" + i)
                    .dueDate(LocalDate.now()).build());
        }
        List<TodoDto> list2 = IntStream.range(0,10).mapToObj(i->{
            return TodoDto.builder()
                    .tno((long) i)
                    .title("todo" + i)
                    .dueDate(LocalDate.now()).build();
        }).collect(Collectors.toList());
        return list2;
    }
}
